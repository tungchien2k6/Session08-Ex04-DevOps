package com.ra.doctorsevice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String specialization;
    private Integer experienceYears;
    private String email;

    @Column(name = "status", nullable = false)
    private Boolean status = true;
}
