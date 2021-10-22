package com.japhy.bootstrap.config;

import com.japhy.bootstrap.config.config.CustomConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @since 2021/8/13 16:43
 */
@Slf4j
@Component
public class CustomApplicationCloseEvent implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        CustomConfig bean = event.getApplicationContext().getBean(CustomConfig.class);
        log.info(bean.getDemo());
    }
}
