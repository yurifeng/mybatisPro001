package com.yuri.maven.dao;

import com.yuri.maven.entity.Department;
import com.yuri.maven.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author yurifeng
 * @create 2018-11-15 13:48
 * @PACKAGE_NAME com.yuri.maven.dao
 * @PROJECT_NAME mybatisPro001
 */
public class DepartmentMapperTest {

    SqlSession sqlSession = MyBatisUtil.sqlSession();

    /**
     * 测试单表查询department
     */
    @Test
    public void getDeptById() {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        System.out.println(mapper.getDeptById(6));
    }

    /**
     * 测试collection多表联合查询
     */
    @Test
    public void getDeptByIdPlus() {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = mapper.getDeptByIdPlus(3);
        System.out.println(department);
        department.getPersons().forEach(System.out::println);

    }
}