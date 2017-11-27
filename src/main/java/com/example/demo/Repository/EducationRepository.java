package com.example.demo.Repository;

import com.example.demo.Entity.Education;

import org.springframework.data.repository.CrudRepository;

public interface EducationRepository extends CrudRepository<Education,Long> {
}
