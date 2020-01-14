package com.japhy.examples.dao;

import com.japhy.examples.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @date 2020/1/14 09:21
 * Dao 模式实现 mybatis 查询
 */
@Component
public class UserDao {

    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User selectById(long id) {
        return this.sqlSession.selectOne("selectUserById", id);
    }
}
