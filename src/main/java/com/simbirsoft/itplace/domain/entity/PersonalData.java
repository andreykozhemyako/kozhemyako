package com.simbirsoft.itplace.domain.entity;
//Хранилище
public class PersonalData {
    //Свойства
    private String FIO;                     //ФИО
    private String DOB;                     //Дата рождения
    private String phone;                   //телефон
    private String email;                   //электронная почта
    private String skype;                   //скайп
    private String avatar;                  //ссылка на аватарку
    private String target;                  //цель
    private String experiences;             //опыт работы
    private String educations;              //образование
    private String additionalEducations;    //дополнительное образование
    private String skills;                  //скилы
   // примеры кода
    public PersonalData(
            String FIO,
            String DOB,
            String phone,
            String email,
            String skype,
            String avatar,
            String target,
            String experiences,
            String educations,
            String additionalEducations,
            String skills) {
        this.FIO = FIO;
        this.DOB = DOB;
        this.phone = phone;
        this.email = email;
        this.skype = skype;
        this.avatar = avatar;
        this.target = target;
        this.experiences = experiences;
        this.educations = educations;
        this.additionalEducations = additionalEducations;
        this.skills = skills;

    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatarPath(String avatar) {
        this.avatar = avatar;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public String getEducations() {
        return educations;
    }

    public void setEducations(String educations) {
        this.educations = educations;
    }

    public String getAdditionalEducations() {
        return additionalEducations;
    }

    public void setAdditionalEducations(String additionalEducations) {
        this.additionalEducations = additionalEducations;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}
