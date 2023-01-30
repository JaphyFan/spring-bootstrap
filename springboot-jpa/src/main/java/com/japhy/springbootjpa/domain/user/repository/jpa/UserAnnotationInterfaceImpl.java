package com.japhy.springbootjpa.domain.user.repository.jpa;

import com.japhy.springbootjpa.domain.user.entity.User;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 * @author Japhy
 * @date 2019/12/30 23:06
 */
@Repository
public class UserAnnotationInterfaceImpl implements UserAnnotationInterfaceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findByNickName(String nickName) {
        return entityManager.createQuery(
                "select t from User t where t.nickName like '%0hf%'", User.class)
                .getResultList();
    }
}
