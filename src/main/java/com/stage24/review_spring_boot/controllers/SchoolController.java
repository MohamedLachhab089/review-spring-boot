package com.stage24.review_spring_boot.controllers;

import com.stage24.review_spring_boot.dtos.SchoolDto;
import com.stage24.review_spring_boot.entities.School;
import com.stage24.review_spring_boot.repositories.SchoolRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private final SchoolRepo schoolRepo;

    public SchoolController(SchoolRepo schoolRepo) {
        this.schoolRepo = schoolRepo;
    }

    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        var school = toSchool(schoolDto);
        schoolRepo.save(school);
        return schoolDto;
    }

    private School toSchool(SchoolDto schoolDto) {
        return new School(schoolDto.name());
    }

    private SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }

    @GetMapping("/schools")
    public List<SchoolDto> getAllSchools() {
        return schoolRepo.findAll()
                .stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }
}
