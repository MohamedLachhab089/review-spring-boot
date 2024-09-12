package com.stage24.review_spring_boot.controllers;

import com.stage24.review_spring_boot.entities.School;
import com.stage24.review_spring_boot.repositories.SchoolRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolRepo schoolRepo;

    public SchoolController(SchoolRepo schoolRepo) {
        this.schoolRepo = schoolRepo;
    }

    @PostMapping("/schools")
    public School createSchool(@RequestBody School school) {
        return schoolRepo.save(school);
    }

    @GetMapping("/schools")
    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }
}
