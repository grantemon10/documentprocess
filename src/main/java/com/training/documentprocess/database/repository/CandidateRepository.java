package com.training.documentprocess.database.repository;

import com.training.documentprocess.database.entity.Candidate;
import com.training.documentprocess.database.entity.Reputation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends
        JpaRepository<Candidate, Long>,
        QuerydslPredicateExecutor<Candidate> {


    @Query(value = "SELECT c.* FROM candidate c WHERE LOWER(c.reputation) = LOWER(:#{#reputation?.toString()})",
            nativeQuery = true)
    List<Candidate> findAllByReputation(@Param("reputation") Reputation reputation);



}
