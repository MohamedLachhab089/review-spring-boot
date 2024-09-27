package com.stage24.review_spring_boot.mappers;

import com.stage24.review_spring_boot.dtos.StudentDto;
import com.stage24.review_spring_boot.dtos.StudentResponseDto;
import com.stage24.review_spring_boot.entities.School;
import com.stage24.review_spring_boot.entities.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setName(dto.name());
        student.setEmail(dto.email());
        student.setAge(dto.age());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(student.getName(), student.getEmail(), student.getAge());
    }
}
