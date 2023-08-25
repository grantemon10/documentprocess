package com.training.documentprocess.http.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.documentprocess.database.entity.Candidate;
import com.training.documentprocess.service.CandidateService;
import com.training.documentprocess.service.OrganizationService;
import com.training.documentprocess.service.SkillService;
import com.training.documentprocess.util.TestDataImporter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/resume")
@RequiredArgsConstructor
public class ResumeRestController {

    private final CandidateService candidateService;
    private final OrganizationService organizationService;
    private final SkillService skillService;

    @RequestMapping("/healthcheck")
    public String healthcheck(){
        return "OK";
    }

    @RequestMapping("/initdb")
    @Autowired
    public String initdb(){

        TestDataImporter.importData(organizationService, skillService, candidateService);
        return "OK";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/registerResume")
    public String registerResume(@RequestBody Candidate candidate){
        log.info(candidate.toString());
        log.info(candidate.getOrganization().toString());
//        Organization organizationByName = organizationService.findOrganizationByName(candidate.getOrganization());
//        log.info(organizationByName.toString());

        return "OK";
    }
}
