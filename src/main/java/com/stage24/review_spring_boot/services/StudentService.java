package com.stage24.review_spring_boot.services;

import com.stage24.review_spring_boot.dtos.StudentDto;
import com.stage24.review_spring_boot.dtos.StudentResponseDto;
import com.stage24.review_spring_boot.entities.Student;
import com.stage24.review_spring_boot.mappers.StudentMapper;
import com.stage24.review_spring_boot.repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto studentDto) {
        var student = studentMapper.toStudent(studentDto);
        var studentResponse = studentRepo.save(student);
        return studentMapper.toStudentResponseDto(studentResponse);
    }

    public List<StudentResponseDto> findAllStudent() {
        return studentRepo.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto findStudentById(Integer stdId) {
        return studentRepo.findById(stdId)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findStudentByName(String name) {
        return studentRepo.findAllByNameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public void deleteStudentById(Integer stdId) {
        studentRepo.deleteById(stdId);
    }
}
