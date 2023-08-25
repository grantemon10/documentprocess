package com.training.documentprocess.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.documentprocess.database.entity.*;
import com.training.documentprocess.service.CandidateService;
import com.training.documentprocess.service.OrganizationService;
import com.training.documentprocess.service.SkillService;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
@UtilityClass
public class TestDataImporter {

    public void importData(OrganizationService organizationService, SkillService skillService, CandidateService candidateService) {


        log.info("Starting importing data::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        Organization microsoft = saveOrganization(organizationService, "Microsoft", Reputation.GOOD);
        Organization apple = saveOrganization(organizationService, "Apple", Reputation.BAD);
        Organization google = saveOrganization(organizationService, "Google", Reputation.GOOD);


        Skill java = saveSkill(skillService, "java");
        Skill spring = saveSkill(skillService, "spring");
        Skill hibernate = saveSkill(skillService, "hibernate");
        Skill sql = saveSkill(skillService, "sql");
        Skill javascript = saveSkill(skillService, "javascript");

        Candidate ivanIvanovich = saveCandidate(candidateService,
                "Ivan Ivanovovich Ivanov",
                microsoft,
                "Developer",
                Level.JUNIOR,
                1500,
                Arrays.asList(java, spring, hibernate),
                "I'm very good developer",
                Reputation.GOOD
        );


        Candidate petrPetrovich = saveCandidate(candidateService,
                "Petr Petrovich Petrov",
                apple,
                "Manager",
                Level.SENIOR,
                2500,
                Arrays.asList(java, sql, javascript),
                "I'm very good manager",
                Reputation.BAD
        );

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            log.info("UserInJson");
            log.info(objectMapper.writeValueAsString(ivanIvanovich));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }


    private Organization saveOrganization(OrganizationService organizationService, String name, Reputation reputation) {
        Organization organization = Organization.builder()
                .name(name)
                .reputation(reputation)
                .build();

        log.info(
                organizationService.create(organization)
                        .toString()
        );

        return organization;

    }

    private Skill saveSkill(SkillService skillService, String name) {
        Skill skill = Skill.builder()
                .name(name)
                .build();

        log.info(
                skillService.create(skill)
                        .toString()
        );

        return skill;
    }

    private Candidate saveCandidate(CandidateService candidateService, String fullname,
                                    Organization organization,
                                    String title,
                                    Level level,
                                    Integer salary,
                                    List<Skill> skills,
                                    String description,
                                    Reputation reputation) {

        Candidate candidate = Candidate.builder()
                .fullname(fullname)
                .organization(organization)
                .title(title)
                .level(level)
                .salary(salary)
                .skills(skills)
                .description(description)
                .reputation(reputation)
                .build();

        log.info(candidateService.create(candidate)
                .toString()
        );

        return candidate;
    }
}
