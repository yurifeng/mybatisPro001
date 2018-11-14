package com.yuri.maven.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("person")
public class Person {
    private Integer id;
    private String userName;
    private Integer age;
    private String mobilePhone;

    public Person() {
    }

    public Person(int id, String userName, int age, String mobilePhone) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.mobilePhone = mobilePhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}
