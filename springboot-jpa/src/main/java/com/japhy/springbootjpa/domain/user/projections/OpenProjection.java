package com.japhy.springbootjpa.domain.user.projections;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Japhy
 * @since 2021/3/19 10:40
 */
public interface OpenProjection {

    @Value("#{target.id + '' + target.name}")
    String combinedIdAndName();
}
