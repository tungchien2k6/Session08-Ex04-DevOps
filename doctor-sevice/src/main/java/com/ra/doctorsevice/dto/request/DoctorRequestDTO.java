package com.ra.doctorsevice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorRequestDTO {

    @NotBlank(message = "Họ và tên không được để trống")
    private String name;
    private String specialization;
    private Integer experienceYears;
    private String email;
    private Boolean status;
}
