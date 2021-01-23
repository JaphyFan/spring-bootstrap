package com.japhy.examples.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author Japhy
 * @date 2020/1/16 13:52
 */
@Component
@ConditionalOnProperty(name = "enabled", prefix = "japhy", havingValue = "true")
@Validated
@ConfigurationProperties(prefix = "japhy", ignoreInvalidFields = true)
@Profile("dev")
public class CustomConfig {

    private boolean enabled;

    private String name;

    private Long age;

    private String phone;

    private String mavenProject;

    private String address;

    private String yamlProperty;

    public String getYamlProperty() {
        return yamlProperty;
    }

    public void setYamlProperty(String yamlProperty) {
        this.yamlProperty = yamlProperty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMavenProject() {
        return mavenProject;
    }

    public void setMavenProject(String mavenProject) {
        this.mavenProject = mavenProject;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
