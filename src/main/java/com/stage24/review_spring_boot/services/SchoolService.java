package com.stage24.review_spring_boot.services;

import com.stage24.review_spring_boot.dtos.SchoolDto;
import com.stage24.review_spring_boot.mappers.SchoolMapper;
import com.stage24.review_spring_boot.repositories.SchoolRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepo schoolRepo;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepo schoolRepo, SchoolMapper schoolMapper) {
        this.schoolRepo = schoolRepo;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto createSchool(SchoolDto schoolDto) {
        var school = schoolMapper.toSchool(schoolDto);
        schoolRepo.save(school);
        return schoolDto;
    }

    public List<SchoolDto> getAllSchools() {
        return schoolRepo.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }
}
