package com.japhy.single.infrastructure.helper;

import static org.junit.jupiter.api.Assertions.*;

import com.japhy.single.domain.account.entity.User;
import java.util.List;
import org.apache.commons.compress.utils.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Japhy
 * @date 2020/1/2 02:14
 */
class ConverterTest {

    private List<User> userList;

    @BeforeEach
    void setUp() {
        userList = Lists.newArrayList();
        User user = new User();
        user.setName("33333");
        user.setPhone("ljlsdfafd");
        userList.add(user);
        User u2 = new User();
        u2.setName("ddddd");
        u2.setPhone("gggggg");
        userList.add(u2);
        User u3 = new User();
        u3.setName("aaaaa");
        u3.setPhone("hhhh");
        userList.add(u3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testConverter() {
        
    }
}