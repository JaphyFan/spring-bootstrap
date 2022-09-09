package com.japhy.bootstrap.web.infrastructure.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Japhy
 * @since 2022/5/31 09:52
 */
public class UserInfoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        String userId = request.getHeader("UserId");
        UserInfoHolder.setContext(UserVo.builder().userId(Long.valueOf(userId)).build());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        UserInfoHolder.clearContext();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
