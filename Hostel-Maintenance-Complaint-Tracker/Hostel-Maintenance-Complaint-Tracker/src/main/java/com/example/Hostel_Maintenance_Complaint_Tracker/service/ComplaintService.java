
package com.example.Hostel_Maintenance_Complaint_Tracker.service;

import com.example.Hostel_Maintenance_Complaint_Tracker.entity.Complaint;
import com.example.Hostel_Maintenance_Complaint_Tracker.entity.Staff;
import com.example.Hostel_Maintenance_Complaint_Tracker.repository.ComplaintRepository;
import com.example.Hostel_Maintenance_Complaint_Tracker.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final StaffRepository staffRepository;

    public ComplaintService(
            ComplaintRepository complaintRepository,
            StaffRepository staffRepository) {

        this.complaintRepository = complaintRepository;
        this.staffRepository = staffRepository;
    }

    // Create a new complaint
    public Complaint createComplaint(Complaint complaint) {
        complaint.setStatus("OPEN");
        return complaintRepository.save(complaint);
    }

    // Get all complaints
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    // Get complaint by ID
    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
    }

    // Update complaint status
    public Complaint updateStatus(Long id, String status) {

        Complaint complaint = getComplaintById(id);

        complaint.setStatus(status);

        if (status.equalsIgnoreCase("RESOLVED")) {
            complaint.setResolvedAt(LocalDateTime.now());
        }

        return complaintRepository.save(complaint);
    }

    // Assign staff to complaint
    public Complaint assignStaff(Long complaintId, Long staffId) {

        Complaint complaint = getComplaintById(complaintId);

        Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        complaint.setStaff(staff);

        return complaintRepository.save(complaint);
    }

    // Get complaints by status
    public List<Complaint> getComplaintsByStatus(String status) {
        return complaintRepository.findByStatus(status);
    }

    // Get complaints submitted by a resident
    public List<Complaint> getComplaintsByResident(Long residentId) {
        return complaintRepository.findByResidentId(residentId);
    }

    // Get complaints by category
    public List<Complaint> getComplaintsByCategory(Long categoryId) {
        return complaintRepository.findByCategoryId(categoryId);
    }

    // Get complaints assigned to staff
    public List<Complaint> getComplaintsByStaff(Long staffId) {
        return complaintRepository.findByStaffId(staffId);
    }
}

