package com.japhy.bootstrap.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Japhy
 * @since 2021/8/20 17:50
 */
public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getBeanFactory().getBean("myBean", MyBean.class).getName().equals("japhy");
    }

}
