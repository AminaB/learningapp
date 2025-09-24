package com.example.learningapp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "course")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
class Course {
    @Id
    private Integer courseID;

    @Column(length = 1000, nullable = false)
    private String courseName;

    @Column(precision = 3, scale = 1, nullable = false)
    private BigDecimal rating;
}
