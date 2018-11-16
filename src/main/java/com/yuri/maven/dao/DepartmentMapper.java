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

    /**
     * 通过department关联查询person
     *
     * @param id
     * @return
     */
    Department getDeptByIdPlus(Integer id);

    /**
     * 通过department关联分布查询person
     *
     * @param id
     * @return
     */
    Department getDeptByIdStep(Integer id);




}
