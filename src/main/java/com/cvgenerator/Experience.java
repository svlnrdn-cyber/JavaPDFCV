package com.cvgenerator;

public class Experience {

    private String company;
    private String position;
    private String startDate;
    private String endDate;
    private String description;

    public Experience(String company, String position,
                      String startDate, String endDate,
                      String description) {

        this.company = company;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }
}