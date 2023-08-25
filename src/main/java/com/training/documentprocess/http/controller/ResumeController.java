package com.training.documentprocess.http.controller;

import com.training.documentprocess.database.entity.Skill;
import com.training.documentprocess.service.SkillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/resume")
@RequiredArgsConstructor
public class ResumeController {
    private final SkillService skillService;

    @GetMapping("/apply")
    public String apply(Model model) {
        List<Skill> skills = skillService.findAll();

        model.addAttribute("skills", skills);
        return "resume/apply";
    }

}
