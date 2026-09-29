package com.example.Hostel_Maintenance_Complaint_Tracker.repository;

import com.example.Hostel_Maintenance_Complaint_Tracker.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
