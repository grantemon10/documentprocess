package com.training.documentprocess.database.repository;

import com.training.documentprocess.database.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends
        JpaRepository<Skill, Long>,
        QuerydslPredicateExecutor<Skill> {

}
