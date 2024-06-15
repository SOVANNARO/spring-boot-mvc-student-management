package org.tutorials.springbootmvcstudentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutorials.springbootmvcstudentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
