package com.ironhand.backend.controller;

import com.ironhand.backend.model.Proposal;
import com.ironhand.backend.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proposals")
@CrossOrigin(origins = "*")
public class ProposalController {

    @Autowired
    private ProposalRepository proposalRepository;

    @PostMapping("/submit")
    public ResponseEntity<?> submitProposal(@RequestBody Proposal proposal) {
        if (proposal.getApplicantEmail() == null || proposal.getApplicantEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Applicant email is required.");
        }
        proposal.setStatus("PENDING");
        proposal.setCreatedAt(LocalDateTime.now());
        proposalRepository.save(proposal);
        return ResponseEntity.ok(proposal);
    }

    @GetMapping("/sent")
    public List<Proposal> getSentProposals(@RequestParam String email) {
        return proposalRepository.findByApplicantEmail(email);
    }

    @GetMapping("/received")
    public List<Proposal> getReceivedProposals(@RequestParam String email) {
        return proposalRepository.findByJobOwnerEmail(email);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateProposalStatus(@PathVariable Long id, @RequestParam String status) {
        Optional<Proposal> optionalProposal = proposalRepository.findById(id);
        if (optionalProposal.isPresent()) {
            Proposal proposal = optionalProposal.get();
            proposal.setStatus(status.toUpperCase());
            proposalRepository.save(proposal);
            return ResponseEntity.ok("Proposal status updated successfully.");
        } else {
            return ResponseEntity.status(404).body("Proposal not found.");
        }
    }
}
