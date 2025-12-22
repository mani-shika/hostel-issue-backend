package com.hostelsystem.hostel_issue_backend.repository;

import com.hostelsystem.hostel_issue_backend.model.HostelIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelIssueRepository extends JpaRepository<HostelIssue, Long> {
}
