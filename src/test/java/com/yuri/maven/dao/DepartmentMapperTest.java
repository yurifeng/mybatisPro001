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

    /**
     * 测试根据department得出person的分步查询
     */
    @Test
    public void getDeptByIdStep() {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = mapper.getDeptByIdStep(6);
        System.out.println(department.getDepartmentName());
        System.out.println(department.getPersons());

    }

    /**
     * 测试二级缓存(SecondLevelCache)
     */
    @Test
    public void testSecondLevelCache() {
        SqlSession sqlSession1 = MyBatisUtil.sqlSession();
        SqlSession sqlSession2 = MyBatisUtil.sqlSession();

        DepartmentMapper mapper1 = sqlSession1.getMapper(DepartmentMapper.class);
        DepartmentMapper mapper2 = sqlSession2.getMapper(DepartmentMapper.class);
        Department department1 = mapper1.getDeptById(1);
        System.out.println(department1);
        sqlSession1.close();
        Department department2 = mapper2.getDeptById(1);
        System.out.println(department2);
        sqlSession2.close();
    }
}