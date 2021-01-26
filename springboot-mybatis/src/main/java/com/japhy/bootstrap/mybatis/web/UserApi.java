package com.japhy.bootstrap.mybatis.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.japhy.bootstrap.mybatis.mapper.UserMapper;
import com.japhy.bootstrap.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @date 2020/1/14 12:21
 */
@RestController
@RequestMapping("api/v1/user")
public class UserApi {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("getById")
    public ResponseEntity<?>  getUserById() {
        User user = userMapper.selectByPrimaryKey(30000L);
        PageInfo<User> page1 = PageHelper.startPage(4, 10)
                .doSelectPageInfo(() -> userMapper.findAll());
        return ResponseEntity.ok(user);
    }

}
