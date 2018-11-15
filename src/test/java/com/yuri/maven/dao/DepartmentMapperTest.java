package com.yuri.maven.dao;

import com.yuri.maven.entity.Department;
import com.yuri.maven.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author yurifeng
 * @create 2018-11-15 10:54
 * @PACKAGE_NAME com.yuri.maven.dao
 * @PROJECT_NAME mybatisPro001
 */
public class DepartmentMapperTest {

    SqlSession sqlSession = MyBatisUtil.sqlSession();

    @Test
    public void getDeptById() {

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department deptById = mapper.getDeptById(6);
        System.out.println(deptById);

    }
}