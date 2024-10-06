package com.demoParsing.testApi.dto;

public class TestDto {
    private String testName;
    private String testEmail;
    private String phone;

    // Default constructor
    public TestDto(){}

    // Parameterized constructor
    public TestDto(String testName, String testEmail, String phone) {
        this.testName = testName;
        this.testEmail = testEmail;
        this.phone = phone;
    }

    // Getters and Setters
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestEmail() {
        return testEmail;
    }

    public void setTestEmail(String testEmail) {
        this.testEmail = testEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Overriding toString method for printing DTO details
    @Override
    public String toString() {
        return "TestDto{" +
                "testName='" + testName + '\'' +
                ", testEmail='" + testEmail + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
