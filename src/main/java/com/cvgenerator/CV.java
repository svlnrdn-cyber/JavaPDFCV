package com.cvgenerator;

public class CV {

    private PersonalInfo personalInfo;
    private Experience experience1;
    private Experience experience2;
    private Experience experience3;

    public CV(PersonalInfo personalInfo,
              Experience experience1,
              Experience experience2,
              Experience experience3) {

        this.personalInfo = personalInfo;
        this.experience1 = experience1;
        this.experience2 = experience2;
        this.experience3 = experience3;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public Experience getExperience1() {
        return experience1;
    }

    public Experience getExperience2() {
        return experience2;
    }

    public Experience getExperience3() {
        return experience3;
    }
}