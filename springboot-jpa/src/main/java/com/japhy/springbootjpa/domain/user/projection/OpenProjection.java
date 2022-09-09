package com.japhy.springbootjpa.domain.user.projection;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Japhy
 * @since 2021/3/19 10:40
 */
public interface OpenProjection extends ProjectionRoot{

    @Value("#{target.id + '' + target.name}")
    String combinedIdAndName();

    String getId();

    String getName();

    @Override
    default String getDescription() {
        return this.getId() + "," + this.getName();
    }
}
