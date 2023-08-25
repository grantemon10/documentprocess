package com.training.documentprocess.database.repository;

import com.training.documentprocess.database.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends
        JpaRepository<Organization, Long>,
        QuerydslPredicateExecutor<Organization> {

    @Query(value = "SELECT o.* FROM organization o WHERE o.name = :name",
            nativeQuery = true)
    List<Organization> findOrganizationByName(@Param("name") String organizationName);
}
