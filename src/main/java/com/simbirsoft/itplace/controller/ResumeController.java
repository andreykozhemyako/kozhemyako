package com.simbirsoft.itplace.controller;


import com.simbirsoft.itplace.domain.entity.PersonalData;
import com.simbirsoft.itplace.service.api.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ResumeController {


    @Autowired
    ServiceInterface service;
    PersonalData data;

    @GetMapping("/resume")
    public String getAllInfo(Model model){

        data = service.getData("person.properties");
        data.makeSplit();

        model.addAttribute("FIO",data.getFIO());
        model.addAttribute("DOB",data.getDOB());
        model.addAttribute("PHONE",data.getPhone());
        model.addAttribute("EMAIL",data.getEmail());
        model.addAttribute("SKYPE",data.getSkype());
        model.addAttribute("AVATAR",data.getAvatar());
        model.addAttribute("TARGET",data.getTarget());
        model.addAttribute("EXP",data.getExpList());
        model.addAttribute("EDU",data.getEducations());
        model.addAttribute("ADDEDU",data.getAdditionalEducations());
        model.addAttribute("SKILLS",data.getSkillsMap());


        return "resume";

    }
}