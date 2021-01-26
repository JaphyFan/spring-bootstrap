package com.japhy.bootstrap.mybatis.mapper;

import com.github.pagehelper.Page;
import com.japhy.bootstrap.mybatis.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAll();

    Page<User> findAllPaged();
}