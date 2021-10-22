package com.japhy.bootstrap.config.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2021/8/20 17:52
 */
@Configuration
public class ConfigurationC {

    @Bean
    @Conditional(MyCondition.class)
//    @ConditionalOnBean(name = {"myBean"})
    public MyClass createMyClass() {
        return new MyClass();
    }
}
