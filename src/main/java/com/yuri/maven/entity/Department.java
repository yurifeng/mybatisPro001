package com.yuri.maven.entity;

import java.util.List;

/**
 * @author yurifeng
 * @create 2018-11-14 20:59
 * @packageName com.yuri.maven.entity
 * @projectName mybatisPro001
 **/

public class Department {

    private Integer id;
    private String departmentName;
    private String location;

    /**
     * 一个department对应多个person
     */
    private List<Person> persons;



    public Department(Integer id, String departmentName, String location, List<Person> persons) {
        this.id = id;
        this.departmentName = departmentName;
        this.location = location;
        this.persons = persons;
    }

    public Department() {
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", location='" + location + '\'' +
                ", persons=" + persons +
                '}';
    }
}
