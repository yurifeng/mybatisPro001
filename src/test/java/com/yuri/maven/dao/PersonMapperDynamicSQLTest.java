package com.yuri.maven.dao;

import com.yuri.maven.entity.Person;
import com.yuri.maven.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yurifeng
 * @create 2018-11-16 16:38
 * @PACKAGE_NAME com.yuri.maven.dao
 * @PROJECT_NAME mybatisPro001
 */
public class PersonMapperDynamicSQLTest {


    SqlSession sqlSession = MyBatisUtil.sqlSession();

    /**
     * 测试DynamicSQL查询(动态sql)
     */
    @Test
    public void getPersonByConditionIf() {
        PersonMapperDynamicSQL mapper = sqlSession.getMapper(PersonMapperDynamicSQL.class);
        Person person = new Person(3, null, null, null);
        mapper.getPersonByConditionIf(person).forEach(System.out::println);
    }
}