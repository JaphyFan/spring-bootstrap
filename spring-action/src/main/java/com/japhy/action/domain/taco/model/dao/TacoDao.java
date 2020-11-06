package com.japhy.action.domain.taco.model.dao;

import com.japhy.action.domain.taco.model.entity.Taco;

/**
 * @author Japhy
 * @since 2020/7/7 11:35
 */
public interface TacoDao {

    Iterable<Taco> findAll();

    Taco findOne(Long id);

    Taco save(Taco taco);

}
