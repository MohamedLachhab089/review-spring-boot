package com.stage24.review_spring_boot.repositories;

import com.stage24.review_spring_boot.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School, Integer> {

}
