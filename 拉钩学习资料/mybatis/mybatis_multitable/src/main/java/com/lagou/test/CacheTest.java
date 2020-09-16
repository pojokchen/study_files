package com.lagou.test;

import com.lagou.mapper.IUserMapper;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheTest {

    private IUserMapper userMapper;
    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(IUserMapper.class);

    }

    @Test
    public void firstLevelCache(){
        // 第一次查询id为1的用户
        User user1 = userMapper.findUserById(1);

        //更新用户
        User user = new User();
        user.setId(1);
        user.setUsername("tom");
        userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.clearCache();

        // 第二次查询id为1的用户
        User user2 = userMapper.findUserById(1);


        System.out.println(user1==user2);
    }


    @Test
    public void SecondLevelCache(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        IUserMapper mapper1 = sqlSession1.getMapper(IUserMapper.class);
        IUserMapper mapper2 = sqlSession2.getMapper(IUserMapper.class);
        IUserMapper mapper3 = sqlSession3.getMapper(IUserMapper.class);

        User user1 = mapper1.findUserById(1);
        sqlSession1.close(); //清空一级缓存


        User user = new User();
        user.setId(1);
        user.setUsername("lisi");
        mapper3.updateUser(user);
        sqlSession3.commit();

        User user2 = mapper2.findUserById(1);

        System.out.println(user1==user2);


    }


}
