package com.example.interviewmanager.entity;

/**
 * 面试信息
 */
public class InterviewMessage {
    private int id;
    private String companyName;
    private String address;
    private String telephone;
    private String contact;//联系人
    private String office;//职位
    private String data;//时间
    private String salary;//薪资


    public InterviewMessage() {
    }

    public InterviewMessage(int id, String companyName,
                            String address, String telephone,
                            String contact, String office, String data, String salary) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.telephone = telephone;
        this.contact = contact;
        this.office = office;
        this.data = data;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "InterviewMessage{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", contact='" + contact + '\'' +
                ", office='" + office + '\'' +
                ", data='" + data + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
