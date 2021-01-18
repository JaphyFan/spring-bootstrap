package com.japhy.springbootjpa.domain.user.repository.jpa;

import com.japhy.springbootjpa.domain.user.entity.User;
import java.util.List;

/**
 * @author Japhy
 * @date 2019/12/30 23:05
 */
public interface UserAnnotationInterfaceRepository {

    /**
     * 根据nickName查询用户
     * @param nickName
     * @return
     */
    List<User> findByNickName(String nickName);
}
