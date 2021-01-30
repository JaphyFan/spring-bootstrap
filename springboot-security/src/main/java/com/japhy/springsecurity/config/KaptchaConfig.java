package com.japhy.springsecurity.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2021/1/27 16:28
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public Producer captcha() {
        Properties properties = new Properties();

        properties.setProperty("kaptcha.image.with", "150");
        properties.setProperty("kaptcha.image.height", "150");
        properties.setProperty("kaptcha.image.textproducer,char.string", "0123456789");
        properties.setProperty("kaptcha.image.textproducer,char.length", "4");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
