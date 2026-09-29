package com.example.Hostel_Maintenance_Complaint_Tracker.controller;

import com.example.Hostel_Maintenance_Complaint_Tracker.entity.Complaint;
import com.example.Hostel_Maintenance_Complaint_Tracker.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    // Create a complaint
    @PostMapping
    public Complaint createComplaint(@RequestBody Complaint complaint) {
        return complaintService.createComplaint(complaint);
    }

    // Get all complaints
    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    // Get complaint by ID
    @GetMapping("/{id}")
    public Complaint getComplaintById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }

    // Update complaint status
    @PutMapping("/{id}/status")
    public Complaint updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return complaintService.updateStatus(id, status);
    }

    // Assign staff to complaint
    @PutMapping("/{complaintId}/assign/{staffId}")
    public Complaint assignStaff(
            @PathVariable Long complaintId,
            @PathVariable Long staffId) {

        return complaintService.assignStaff(complaintId, staffId);
    }

    // Test controller
    @GetMapping("/test")
    public String test() {
        return "Complaint Controller is working";
    }

    // Get complaints by status
    @GetMapping("/status/{status}")
    public List<Complaint> getComplaintsByStatus(
            @PathVariable String status) {

        return complaintService.getComplaintsByStatus(status);
    }

    // Get complaints by resident
    @GetMapping("/resident/{residentId}")
    public List<Complaint> getComplaintsByResident(
            @PathVariable Long residentId) {

        return complaintService.getComplaintsByResident(residentId);
    }

    // Get complaints by category
    @GetMapping("/category/{categoryId}")
    public List<Complaint> getComplaintsByCategory(
            @PathVariable Long categoryId) {

        return complaintService.getComplaintsByCategory(categoryId);
    }

    // Get complaints assigned to staff
    @GetMapping("/staff/{staffId}")
    public List<Complaint> getComplaintsByStaff(
            @PathVariable Long staffId) {

        return complaintService.getComplaintsByStaff(staffId);
    }
}