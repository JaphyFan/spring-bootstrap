package com.japhy.bootstrap.mongo;

import com.japhy.bootstrap.mongo.jpa.UserRepository;
import com.japhy.bootstrap.mongo.template.UserRepositoryTemplate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author Japhy
 * @since 2023/4/12 17:47
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserRepositoryTemplate userRepositoryTemplate;

    public void deleteUsersByRepository() {
        userRepository.deleteAll();
    }

    public void saveUsersByRepository(List<User> userList) {
        userRepository.saveAll(userList);
    }

    @Transactional
    public void combinedOperationWithRepository() {
        deleteUsersByRepository();
        long l = countAllByRepository();
        System.out.println("当前数据库数据为0" + (l == 0));
        // 抛出异常
        throwException();
    }

    void throwException() {
        throw new RuntimeException("throwTestException");
    }

    @Transactional(readOnly = true)
    public User findUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Boolean testReadOnlyTransaction() {
        findUserById("1");
        boolean currentTransactionReadOnly =
                TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        return currentTransactionReadOnly;
    }

    public long countAllByRepository() {
        return userRepository.count();
    }


    public long countAllWithTemplate() {
        return userRepositoryTemplate.countAll();
    }

    public void deleteAllWithTemplate() {
        userRepositoryTemplate.deleteAll();
    }

    @Transactional
    public void combinedOperationWithTemplate() {
        deleteAllWithTemplate();
        long l = countAllWithTemplate();
        System.out.println("当前数据库数据为0" + (l == 0));
        // 抛出异常
        throwException();
    }


    public Page<User> findPageByRepository(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
