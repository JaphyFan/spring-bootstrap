package com.japhy.bootstrap.web.infrastructure.helper;

import java.util.Optional;
import org.springframework.util.Assert;

/**
 * @author Japhy
 * @since 2022/5/30 17:30
 */
public class UserInfoHolder {

    private static ThreadLocal<UserVo> user = new ThreadLocal<>();

    public static Long currentUserId() {
        return Optional.ofNullable(user.get()).map(UserVo::getUserId).orElse(null);
    }

    public static void clearContext() {
        user.remove();
    }

    public static void setContext(UserVo userVo) {
        Assert.notNull(userVo, "user info can't be null");
        user.set(userVo);
    }

}
