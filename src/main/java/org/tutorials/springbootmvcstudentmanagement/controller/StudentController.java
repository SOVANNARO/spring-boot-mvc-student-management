package org.tutorials.springbootmvcstudentmanagement.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.tutorials.springbootmvcstudentmanagement.dto.StudentDto;
import org.tutorials.springbootmvcstudentmanagement.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // handle list all students
    @GetMapping("/students")
    public String listStudents(Model model) {
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    // handel create new student
    @GetMapping("/students/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new StudentDto());
        return "create-student";
    }

    // handel save new student
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto studentDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-student";
        }
        studentService.saveStudent(studentDto);
        return "redirect:/students";
    }

    // handel edit student
    @GetMapping("/students/{id}/edit")
    public String editStudent(@PathVariable("id") Long id,
                              Model model){
        StudentDto student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    // handel edit student
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long id,
                                @Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result,
                                Model model){
        if (result.hasErrors()) {
            studentDto.setId(id);
            return "edit-student";
        }
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

    // handle delete student
    @GetMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable("id") Long id,
                                Model model){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    // handle view student
    @GetMapping("/students/{id}/detail")
    public String viewStudent(@PathVariable("id") Long id,
                              Model model){
        StudentDto student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "detail-student";
    }
}
