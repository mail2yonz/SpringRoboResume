
package com.example.demo.Entity;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Configuration
public class UserData {

    private ArrayList<Skill> skillList;
    private ArrayList<Experience> experienceList;
    private ArrayList<Education> educationList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    private String username;

    private String password;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Education> educations;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Experience> experiences;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Skill> skills;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))

    private Collection<UserRole> roles;

    public UserData() {
    }

    public UserData(ArrayList<Skill> skillList, ArrayList<Experience> experienceList, ArrayList<Education> educationList, String name, String email, String username, String password, Set<Education> educations, Set<Experience> experiences, Set<Skill> skills) {
        this.skillList = skillList;
        this.experienceList = experienceList;
        this.educationList = educationList;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.educations = educations;
        this.experiences = experiences;
        this.skills = skills;
    }

    public UserData(ArrayList<Skill> skillList, ArrayList<Experience> experienceList, ArrayList<Education> educationList, String name, String email, String username, String password, Set<Education> educations, Set<Experience> experiences, Set<Skill> skills, Collection<UserRole> roles) {
        this.skillList = skillList;
        this.experienceList = experienceList;
        this.educationList = educationList;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.educations = educations;
        this.experiences = experiences;
        this.skills = skills;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Education> getEducations() {
        return educations;
    }
    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }
    public Set<Experience> getExperiences() {
        return experiences;
    }
    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }
    public Set<Skill> getSkills() {
        return skills;
    }
    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Collection<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<UserRole> roles) {
        this.roles = roles;
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;
    }

    public ArrayList<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(ArrayList<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public ArrayList<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(ArrayList<Education> educationList) {
        this.educationList = educationList;
    }
}