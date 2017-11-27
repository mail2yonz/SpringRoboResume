package com.example.demo.Controller;

import com.example.demo.Entity.*;

import com.example.demo.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller

public class MainController {

    @Autowired
    UserData userData;
    @Autowired
    Job job;


    @Autowired
    UserRepository userRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SkillRepository skillRepository;

    public MainController() {
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }



    @GetMapping("/")
    public String loadUserForm(Model model) {
        if (userRepository.count()>=1) {
            return "userpage";
        }
        model.addAttribute("user", new UserData());
        return "userform";
    }


//    @RequestMapping("/addUser")
//    public String adduser(Model model)
//    {
//        model.addAttribute("user",new UserData());
//
//        return "userform";
//    }

    @PostMapping("/addUser")
    public String processUserForm(@Valid @ModelAttribute("user") UserData user, BindingResult result) {
        if (result.hasErrors()) {
            return "userform";
        }
        userRepository.save(user);
        return "redirect:/addEducation";
    }


    @GetMapping("/addEducation")
    public String loadEducationForm(Model model) {
        if (educationRepository.count()>10) {
            return "limit";
        }
        model.addAttribute("education", new Education());
        return "educationform";
    }

    @PostMapping("/addEducation")
    public String processEducationForm(@Valid @ModelAttribute("education") Education education, BindingResult result) {
        if (result.hasErrors()) {
            return "educationform";
        }
        educationRepository.save(education);
        return "redirect:/addExperience";
    }


    @GetMapping("/addExperience")
    public String loadExperienceForm(Model model) {
        if (experienceRepository.count()>20) {
            return "limit";
        }
        model.addAttribute("experience", new Experience());
        return "experienceform";
    }

    @PostMapping("/addExperience")
    public String processExperienceForm(@Valid @ModelAttribute("experience") Experience experience, BindingResult result) {
        if (result.hasErrors()) {
            return "experienceform";
        }
        experienceRepository.save(experience);
        return "redirect:/addSkill";
    }


    @GetMapping("/addSkill")
    public String loadSkillForm(Model model) {
        model.addAttribute("skills", new Skill());
        return "skillform";
    }

    @PostMapping("/addSkill")
    public String processSkillForm(@Valid @ModelAttribute("skills") Skill skill, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "skillform";
        }
        skillRepository.save(skill);
        model.addAttribute(new Skill());
        return "redirect:/";
    }

    @GetMapping("/showAll")
    public String displayAll(Model model) {
        if (userRepository.count()==0 || educationRepository.count()==0 || skillRepository.count()==0) {
            return "error";
        }
        UserData user = new UserData();
        Iterable<UserData> allUsers = userRepository.findAll();
        model.addAttribute("users", allUsers);

        Iterable<Education> allEducations = educationRepository.findAll();
        ArrayList<Education> educationList = new ArrayList<>();
        educationList = (ArrayList<Education>) allEducations;
        user.setEducationList(educationList);
        model.addAttribute("educations", user.getEducationList());

        Iterable<Experience> allExperiences = experienceRepository.findAll();
        ArrayList<Experience> experienceList = new ArrayList<>();
        experienceList = (ArrayList<Experience>) allExperiences;
        user.setExperienceList(experienceList);
        model.addAttribute("experiences", user.getExperienceList());

        Iterable<Skill> allSkills = skillRepository.findAll();
        ArrayList<Skill> skillList = new ArrayList<>();
        skillList = (ArrayList<Skill>) allSkills;
        user.setSkillList(skillList);
        model.addAttribute("skills", user.getSkillList());

        return "showresumes";
    }
    @RequestMapping("/list")
    public String listofResumes(Model model)
    {
        model.addAttribute("users", userRepository.findAll());

        return "list";
    }

    //List of all users resume

    //list of all resume that satisfy the job description

//    @RequestMapping("/listqualified")
//
//    public String listofUsersSatisfyingJobDes(Model model)
//    {
//
//        model.addAttribute("users", userRepository.findAll());
//
//        for(Skill skill: userData.getSkillList())
//        {
//            if(skill.getSkill().equalsIgnoreCase(job.getSkill()))
//            {
//                return "listrequired";
//            }
//
//
//        }
//
//        return "list";
//
//    }



}
