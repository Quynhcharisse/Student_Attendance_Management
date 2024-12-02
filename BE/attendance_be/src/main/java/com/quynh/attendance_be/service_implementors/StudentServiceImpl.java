package com.quynh.attendance_be.service_implementors;

import com.quynh.attendance_be.models.Student;
import com.quynh.attendance_be.repositories.StudentRepo;
import com.quynh.attendance_be.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }


}
