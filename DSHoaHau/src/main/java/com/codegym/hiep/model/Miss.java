package com.codegym.hiep.model;

public class Miss {
    private String name;
    private String birthDay;
    private String address;
    private String numberPhone;
    private String email;
    private int passport;
    private String job;
    private String level;
    private String nation;
    private String workUnit;
    private float height;
    private float weight;
    private String gifted;
    private String image;
    private String status;
    private String province="";

    public Miss(String name, String birthDay, String address, String numberPhone, String email, int passport, String job, String level, String nation, String workUnit, float height, float weight, String gifted, String image,String status,  String province) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.numberPhone = numberPhone;
        this.email = email;
        this.passport = passport;
        this.job = job;
        this.level = level;
        this.nation = nation;
        this.workUnit = workUnit;
        this.height = height;
        this.weight = weight;
        this.gifted = gifted;
        this.image = image;
        this.status = status;
        this.province = province;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getGifted() {
        return gifted;
    }

    public void setGifted(String gifted) {
        this.gifted = gifted;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
