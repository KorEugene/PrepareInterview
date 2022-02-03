package ru.korchevoyeo.lesson7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.korchevoyeo.lesson7.entity.Student;
import ru.korchevoyeo.lesson7.repository.StudentRepository;

@RequiredArgsConstructor
@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/")
    public String showStudentList(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    @GetMapping("/addstudent")
    public String showSaveForm() {
        return "add-student";
    }

    @PostMapping("/addstudent")
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        studentRepository.delete(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.getById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    @PostMapping("/update")
    public String updateUser(Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }
}
