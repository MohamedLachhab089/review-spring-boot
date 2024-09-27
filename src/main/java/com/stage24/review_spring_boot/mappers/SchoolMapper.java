package com.stage24.review_spring_boot.mappers;

import com.stage24.review_spring_boot.dtos.SchoolDto;
import com.stage24.review_spring_boot.entities.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDto schoolDto) {
        return new School(schoolDto.name());
    }

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }
}
