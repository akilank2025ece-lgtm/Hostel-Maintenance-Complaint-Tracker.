package com.example.Hostel_Maintenance_Complaint_Tracker.repository;

import com.example.Hostel_Maintenance_Complaint_Tracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}