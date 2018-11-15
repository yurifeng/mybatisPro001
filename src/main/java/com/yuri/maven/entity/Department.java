package com.yuri.maven.entity;

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

    public Department(Integer id, String departmentName, String location) {
        this.id = id;
        this.departmentName = departmentName;
        this.location = location;
    }

    public Department() {
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
                '}';
    }
}
