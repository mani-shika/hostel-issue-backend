package com.hostelsystem.hostel_issue_backend.service;

import com.hostelsystem.hostel_issue_backend.model.HostelIssue;
import com.hostelsystem.hostel_issue_backend.repository.HostelIssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostelIssueService {

    private final HostelIssueRepository repository;

    public HostelIssueService(HostelIssueRepository repository) {
        this.repository = repository;
    }

    public HostelIssue createIssue(HostelIssue issue) {
        return repository.save(issue);
    }

    public List<HostelIssue> getAllIssues() {
        return repository.findAll();
    }

    public Optional<HostelIssue> getIssueById(Long id) {
        return repository.findById(id);
    }

    public HostelIssue updateIssue(Long id, HostelIssue updatedIssue) {
        HostelIssue existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setStudentName(updatedIssue.getStudentName());
        existing.setRoomNumber(updatedIssue.getRoomNumber());
        existing.setIssueTitle(updatedIssue.getIssueTitle());
        existing.setIssueDescription(updatedIssue.getIssueDescription());
        existing.setCategory(updatedIssue.getCategory());
        existing.setPriority(updatedIssue.getPriority());
        existing.setStatus(updatedIssue.getStatus());

        return repository.save(existing);
    }

    public void deleteIssue(Long id) {
        repository.deleteById(id);
    }
}
