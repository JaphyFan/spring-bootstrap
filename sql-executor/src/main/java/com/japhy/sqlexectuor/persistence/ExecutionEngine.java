package com.japhy.sqlexectuor.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2022/4/7 13:45
 */
@Service
@RequiredArgsConstructor
public class ExecutionEngine {

    private final EntityManager entityManager;

    public void executeSql(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        List resultList = nativeQuery.getResultList();
    }

}
