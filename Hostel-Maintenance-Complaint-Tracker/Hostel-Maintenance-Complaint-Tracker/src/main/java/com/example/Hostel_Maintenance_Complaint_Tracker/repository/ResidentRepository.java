package com.example.Hostel_Maintenance_Complaint_Tracker.repository;

import com.example.Hostel_Maintenance_Complaint_Tracker.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
}