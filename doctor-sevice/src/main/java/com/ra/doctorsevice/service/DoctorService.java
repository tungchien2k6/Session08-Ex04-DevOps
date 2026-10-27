package com.ra.doctorsevice.service;

import com.ra.doctorsevice.dto.request.DoctorRequestDTO;
import com.ra.doctorsevice.dto.response.DoctorResponseDTO;

public interface DoctorService {
    DoctorResponseDTO createDoctor(DoctorRequestDTO request);
    DoctorResponseDTO getDoctorById(Long id);
}
