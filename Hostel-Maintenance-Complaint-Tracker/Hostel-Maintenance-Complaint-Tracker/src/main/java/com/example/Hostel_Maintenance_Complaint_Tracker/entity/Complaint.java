package com.example.Hostel_Maintenance_Complaint_Tracker.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime resolvedAt;

    // Resident who submitted the complaint
    @ManyToOne
    @JoinColumn(name = "resident_id", nullable = false)
    private Resident resident;

    // Category of the complaint
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Staff assigned to handle the complaint
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    public Complaint() {
        this.createdAt = LocalDateTime.now();
        this.status = "OPEN";
    }

    public Complaint(String description, Resident resident, Category category) {
        this.description = description;
        this.resident = resident;
        this.category = category;
        this.status = "OPEN";
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
