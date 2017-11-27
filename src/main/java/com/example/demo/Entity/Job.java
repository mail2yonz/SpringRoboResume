package com.example.demo.Entity;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Set;

@Entity
@Configuration
public class Job {

     @Id
    private Long id;
    private String skill;

    private String company;

    public Job() {
    }

    public Job(String skill, String company) {
        this.skill = skill;
        this.company = company;
    }

    public Job(Long id, String skill, String company, Set<Skill> skillSet) {
        this.id = id;
        this.skill = skill;
        this.company = company;
        this.skillSet = skillSet;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Skill> skillSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    /*
    *
    * public String search forUsers()
    * {
    *
    *
    * }
    *
    *
    *
    *
    *
    * */
}
