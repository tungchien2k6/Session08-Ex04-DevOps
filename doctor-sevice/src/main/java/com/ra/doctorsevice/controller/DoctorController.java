package com.ra.doctorsevice.controller;

import com.ra.doctorsevice.dto.request.DoctorRequestDTO;
import com.ra.doctorsevice.dto.response.DoctorResponseDTO;
import com.ra.doctorsevice.service.DoctorService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> createDoctor(@Valid @RequestBody DoctorRequestDTO request) {
        return new ResponseEntity<>(doctorService.createDoctor(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @RateLimiter(name = "searchDoctorLimit", fallbackMethod = "getDoctorByIdFallback")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    public ResponseEntity<?> getDoctorByIdFallback(Long id, Throwable t) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", 429);
        response.put("message", "Error");
        response.put("data", "Bạn đã gửi quá 5 request mỗi 10 giây");

        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(response);
    }
}