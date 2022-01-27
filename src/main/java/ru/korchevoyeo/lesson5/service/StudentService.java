package ru.korchevoyeo.lesson5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korchevoyeo.lesson5.dao.StudentDao;
import ru.korchevoyeo.lesson5.entity.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @PostConstruct
    public void init() {
        List<Student> students = new ArrayList<>();

        int lowerMarkBound = 1;
        int upperMarkBound = 5;
        int leftLimit = 97; // буква 'a'
        int rightLimit = 122; // буква 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder sb = new StringBuilder(targetStringLength);

        for (int x = 1; x <= 1000; x++) {
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + random.nextInt(rightLimit - leftLimit + 1);
                sb.append((char) randomLimitedInt);
            }
            students.add(new Student(null, sb.toString(), 1 + (int) (Math.random() * 5)));
            sb.setLength(0);
        }

        for (Student student : students) { // заполняем БД
            save(student);
        }
    }

    public List<Student> findAll() {
        return studentDao.findAll().stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
    }

    public Student findById(Long id) {
        return studentDao.findById(id);
    }

    public Student save(Student student) {
        return studentDao.save(student);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }
}
