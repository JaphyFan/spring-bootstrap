package com.japhy.bootstrap.mongo;

/**
 * 使用SpringData的projection会在mongodb中查询出添加Projection
 * qsl例子: {"find": "user", "filter": {"name": "fan"}, "projection": {"name": 1}
 *
 * @author Japhy
 * @since 2023/4/16 02:28
 */
public interface UserProjection {

    String getName();

}
