package com.japhy.action.domain.taco.model.dao;

import com.japhy.action.domain.taco.model.entity.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Japhy
 * @since 2020/7/7 14:41
 */
@Repository
public interface TacoJpaRepository extends JpaRepository<Taco, Long> {

    @Query("select o from Taco o where o.name = ?1")
    Taco findBydemo(String name);

}
