package com.training.documentprocess.service;

import com.training.documentprocess.database.entity.Skill;
import com.training.documentprocess.database.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SkillService {
    private final SkillRepository skillRepository;

    public List<Skill> findAll() {
        return skillRepository.findAll().stream()
                .toList();
    }

    @Transactional
    public Skill create(Skill candidate) {
        return Optional.of(candidate)
                .map(skillRepository::save)
                .orElseThrow();
    }



}
