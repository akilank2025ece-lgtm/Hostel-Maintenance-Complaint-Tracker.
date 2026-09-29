package com.example.Hostel_Maintenance_Complaint_Tracker.repository;

import com.example.Hostel_Maintenance_Complaint_Tracker.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByStatus(String status);

    List<Complaint> findByResidentId(Long residentId);

    List<Complaint> findByCategoryId(Long categoryId);

    List<Complaint> findByStaffId(Long staffId);
}