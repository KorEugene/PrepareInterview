package ru.korchevoyeo.lesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.korchevoyeo.lesson7.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
