package com.ironhand.backend.repository;

import com.ironhand.backend.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    List<Proposal> findByApplicantEmail(String applicantEmail);
    List<Proposal> findByJobOwnerEmail(String jobOwnerEmail);
}
