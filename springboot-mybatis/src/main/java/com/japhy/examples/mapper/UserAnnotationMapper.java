package com.japhy.examples.mapper;

import com.japhy.examples.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Japhy
 * @date 2020/1/12 21:44
 */
@Mapper
public interface UserAnnotationMapper {

    /**
     * 使用注解的方式查询 User 表 ID为userId 的用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{userId} ")
    User findById(@Param("userId") Long id);
}
