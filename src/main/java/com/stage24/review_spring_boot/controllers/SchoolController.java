package com.stage24.review_spring_boot.controllers;

import com.stage24.review_spring_boot.dtos.SchoolDto;
import com.stage24.review_spring_boot.entities.School;
import com.stage24.review_spring_boot.repositories.SchoolRepo;
import com.stage24.review_spring_boot.services.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.createSchool(schoolDto);
    }



    @GetMapping("/schools")
    public List<SchoolDto> getAllSchools() {
        return schoolService.getAllSchools();
    }
}
