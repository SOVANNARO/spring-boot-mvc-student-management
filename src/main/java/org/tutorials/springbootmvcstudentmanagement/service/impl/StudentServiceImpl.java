package org.tutorials.springbootmvcstudentmanagement.service.impl;

import org.springframework.stereotype.Service;
import org.tutorials.springbootmvcstudentmanagement.dto.StudentDto;
import org.tutorials.springbootmvcstudentmanagement.entity.Student;
import org.tutorials.springbootmvcstudentmanagement.mapper.StudentMapper;
import org.tutorials.springbootmvcstudentmanagement.repository.StudentRepository;
import org.tutorials.springbootmvcstudentmanagement.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
