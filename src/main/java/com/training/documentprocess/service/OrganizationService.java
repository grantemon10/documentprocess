package com.training.documentprocess.service;

import com.training.documentprocess.database.entity.Organization;
import com.training.documentprocess.database.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Transactional
    public Organization create(Organization organization) {
        return Optional.of(organization)
                .map(organizationRepository::save)
                .orElseThrow();
    }

    @Transactional
    public Organization findOrganizationByName(Organization organization){
        Optional<Organization> organizationByName = organizationRepository.findOrganizationByName(organization.getName()).stream().findFirst();
        return organizationByName.orElseThrow();

    }
}
