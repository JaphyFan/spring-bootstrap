package com.japhy.cloud.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.ComponentScan;

/**
 * 用于加载异常控制返回.
 *
 * @author Japhy
 * @since 2022/1/18 13:30
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@AutoConfigurationPackage
@ComponentScan(basePackages = "com.japhy.cloud.common")
//@Import(AutoConfigurationImportSelector.class)
public @interface RestApi {

}
