package com.japhy.bootstrap.web.infrastructure.helper;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

/**
 * 异步方法异常捕获
 * @author Japhy
 * @since 2021/3/10 16:50
 */
@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        if (log.isErrorEnabled()) {
            log.error("Unexpected exception occurred invoking async method: " + method, ex);
        }
    }
}
