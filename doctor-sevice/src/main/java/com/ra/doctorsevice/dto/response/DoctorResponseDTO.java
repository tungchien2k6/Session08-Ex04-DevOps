package com.ra.doctorsevice.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponseDTO {

    private Long id;
    private String name;
    private String specialization;
    private Integer experienceYears;
    private String email;
    private Boolean status;
}
