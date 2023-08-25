package com.training.documentprocess.service;

import com.training.documentprocess.database.entity.Candidate;
import com.training.documentprocess.database.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CandidateService {
    private final CandidateRepository candidateRepository;

    @Transactional
    public Candidate create(Candidate candidate) {
        return Optional.of(candidate)
                .map(candidateRepository::save)
                .orElseThrow();
    }

}
