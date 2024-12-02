package com.quynh.attendance_be.repositories;

import com.quynh.attendance_be.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
