package com.example.interviewmanager.entity;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 面试信息
 */
public class InterviewMessage implements Parcelable{
    private int id;
    private String companyName;
    private String address;
    private String telephone;
    private String contact;//联系人
    private String office;//职位
    private String date;//时间
    private String salary;//薪资
    private String remark;//备注

    public InterviewMessage() {
    }
    public InterviewMessage(int id, String companyName,
                            String address, String telephone,
                            String contact, String office,
                            String date, String salary, String remark) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.telephone = telephone;
        this.contact = contact;
        this.office = office;
        this.date = date;
        this.salary = salary;
        this.remark = remark;
    }

    public InterviewMessage(Parcel source) {
        id=source.readInt();
        companyName=source.readString();
        address=source.readString();
        telephone=source.readString();
        contact=source.readString();
        office=source.readString();
        date=source.readString();
        salary=source.readString();
        remark=source.readString();

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
                ", date='" + date + '\'' +
                ", salary='" + salary + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
          dest.writeString(companyName);
          dest.writeString(address);
          dest.writeString(telephone);
          dest.writeString(contact);
          dest.writeString(office);
          dest.writeString(date);
          dest.writeString(salary);
          dest.writeString(remark);
          dest.writeInt(id);
    }

    public static final Parcelable.Creator<InterviewMessage> CREATOR=
            new Parcelable.Creator<InterviewMessage>() {
                @Override
                public InterviewMessage createFromParcel(Parcel source) {
                    return new InterviewMessage(source);
                }

                @Override
                public InterviewMessage[] newArray(int size) {
                    return new InterviewMessage[size];
                }
            };
}
