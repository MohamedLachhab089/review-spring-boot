package com.stage24.review_spring_boot.dtos;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(@NotEmpty(message = "name shouldn't be empty") String name,
                         String email, int age,
                         Integer schoolId) {

}
