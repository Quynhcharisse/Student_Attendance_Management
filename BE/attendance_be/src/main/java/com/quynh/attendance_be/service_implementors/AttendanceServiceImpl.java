package com.quynh.attendance_be.service_implementors;

import com.quynh.attendance_be.models.Attendance;
import com.quynh.attendance_be.models.Student;
import com.quynh.attendance_be.repositories.AttendanceRepo;
import com.quynh.attendance_be.repositories.StudentRepo;
import com.quynh.attendance_be.services.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepo attendanceRepo;
    private final StudentRepo studentRepo;

    @Override
    public void initAttendance() {
        for (Student student : studentRepo.findAll()) {
            attendanceRepo.save(
                    Attendance.builder()
                            .date(LocalDateTime.now())
                            .reason("")
                            .status("absent")
                            .student(student)
                            .build()
            );
        }
    }
}
