package com.quynh.attendance_be.repositories;

import com.quynh.attendance_be.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer> {
}
