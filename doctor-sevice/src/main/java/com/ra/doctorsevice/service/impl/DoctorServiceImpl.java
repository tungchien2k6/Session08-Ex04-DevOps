package com.ra.doctorsevice.service.impl;

import com.ra.doctorsevice.dto.request.DoctorRequestDTO;
import com.ra.doctorsevice.dto.response.DoctorResponseDTO;
import com.ra.doctorsevice.entity.Doctor;
import com.ra.doctorsevice.repository.DoctorRepository;
import com.ra.doctorsevice.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorResponseDTO createDoctor(DoctorRequestDTO request) {
        Doctor doctor = Doctor.builder()
                .name(request.getName())
                .specialization(request.getSpecialization())
                .experienceYears(request.getExperienceYears())
                .email(request.getEmail())
                .status(request.getStatus())
                .build();

        Doctor savedDoctor = doctorRepository.save(doctor);

        return DoctorResponseDTO.builder()
                .id(savedDoctor.getId())
                .name(savedDoctor.getName())
                .specialization(savedDoctor.getSpecialization())
                .experienceYears(savedDoctor.getExperienceYears())
                .email(savedDoctor.getEmail())
                .status(savedDoctor.getStatus())
                .build();
    }

    @Override
    public DoctorResponseDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Không tìm thấy bác sĩ với ID: " + id
                ));

        return mapToResponseDTO(doctor);
    }

    private DoctorResponseDTO mapToResponseDTO(Doctor doctor) {
        return DoctorResponseDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .specialization(doctor.getSpecialization())
                .experienceYears(doctor.getExperienceYears())
                .email(doctor.getEmail())
                .status(doctor.getStatus())
                .build();
    }
}
