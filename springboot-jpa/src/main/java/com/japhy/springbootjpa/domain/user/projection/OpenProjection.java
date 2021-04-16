package com.japhy.springbootjpa.domain.user.projection;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Japhy
 * @since 2021/3/19 10:40
 */
public interface OpenProjection {

    @Value("#{target.id + '' + target.name}")
    String combinedIdAndName();

    String getId();

    String getName();
}
