package org.tutorials.springbootmvcstudentmanagement.service;

import org.springframework.stereotype.Service;
import org.tutorials.springbootmvcstudentmanagement.dto.StudentDto;

import java.util.List;

@Service
public interface StudentService {
    List<StudentDto> getAllStudents();

    void saveStudent(StudentDto studentDto);

    StudentDto getStudentById(Long id);

    void updateStudent(StudentDto studentDto);

    void deleteStudentById(Long id);
}
