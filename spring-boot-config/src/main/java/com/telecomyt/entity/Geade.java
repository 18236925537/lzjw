package com.telecomyt.entity;

public class Geade {

    private String gradeName;
    private String gradeCode;

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    @Override
    public String toString() {
        return "Geade{" +
                "gradeName='" + gradeName + '\'' +
                ", gradeCode='" + gradeCode + '\'' +
                '}';
    }
}
