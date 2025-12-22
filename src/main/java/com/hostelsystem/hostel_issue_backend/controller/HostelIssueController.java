package com.hostelsystem.hostel_issue_backend.controller;

import com.hostelsystem.hostel_issue_backend.model.HostelIssue;
import com.hostelsystem.hostel_issue_backend.service.HostelIssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/issues")
@CrossOrigin
public class HostelIssueController {

    private final HostelIssueService service;

    public HostelIssueController(HostelIssueService service) {
        this.service = service;
    }

    // ✅ Create Issue
    @PostMapping
    public HostelIssue createIssue(@RequestBody HostelIssue issue) {
        return service.createIssue(issue);
    }

    // ✅ Get All Issues
    @GetMapping
    public List<HostelIssue> getAllIssues() {
        return service.getAllIssues();
    }

    // ✅ Get Issue By ID
    @GetMapping("/{id}")
    public Optional<HostelIssue> getIssueById(@PathVariable Long id) {
        return service.getIssueById(id);
    }

    // ✅ Update Issue
    @PutMapping("/{id}")
    public HostelIssue updateIssue(
            @PathVariable Long id,
            @RequestBody HostelIssue issue
    ) {
        return service.updateIssue(id, issue);
    }

    // ✅ Delete Issue
    @DeleteMapping("/{id}")
    public void deleteIssue(@PathVariable Long id) {
        service.deleteIssue(id);
    }
}
