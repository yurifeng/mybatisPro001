package com.yuri.maven.entity;

//@Alias("person")
public class Person {
    private Integer id;
    private String userName;
    private Integer age;
    private String mobilePhone;

    /**
     * 一个person对应一个department
     */
    private Department dept;


    public Person() {
    }

    public Person(Integer id, String userName, Integer age, String mobilePhone) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.mobilePhone = mobilePhone;
    }

    public Person(String userName, Integer age, String mobilePhone) {
        this.userName = userName;
        this.age = age;
        this.mobilePhone = mobilePhone;
    }

    public Person(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public Person(String userName) {
        this.userName = userName;
    }

    public Person(String userName, String mobilePhone) {
        this.userName = userName;
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

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
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
