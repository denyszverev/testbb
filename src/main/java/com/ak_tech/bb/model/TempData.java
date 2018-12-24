package com.ak_tech.bb.model;

public class TempData {
    private String year;
    private String value;
    private String email;

    public String getYear() {
        return year;
    }

    public TempData withYear(String year) {
        this.year = year;
        return this;
    }

    public String getValue() {
        return value;
    }

    public TempData withValue(String value) {
        this.value = value;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TempData withEmail(String email) {
        this.email = email;
        return this;
    }
}
