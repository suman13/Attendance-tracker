package com.ge.atracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ge.atracker.model.Student;

@Repository
public interface StudentRepoImpl extends JpaRepository<Student, String> {
}
