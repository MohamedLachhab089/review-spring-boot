package com.stage24.review_spring_boot.repositories;

import com.stage24.review_spring_boot.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findAllByNameContaining(String name);
}
