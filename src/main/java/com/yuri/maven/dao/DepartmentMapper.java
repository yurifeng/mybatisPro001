package com.yuri.maven.dao;

import com.yuri.maven.entity.Department;

/**
 * @author yurifeng
 * @create 2018-11-15 10:42
 * @PACKAGE_NAME com.yuri.maven.dao
 * @PROJECT_NAME mybatisPro001
 */
public interface DepartmentMapper {


    Department getDeptById(Integer id);

    Department getDeptByIdPlus(Integer id);


}
