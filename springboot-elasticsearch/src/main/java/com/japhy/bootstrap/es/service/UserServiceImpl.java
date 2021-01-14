package com.japhy.bootstrap.es.service;

import com.japhy.bootstrap.es.model.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2020/7/16 15:40
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public User saveUser(User user) {
        User save = elasticsearchOperations.save(user);
        return save;
    }

    @Override
    public Optional<User> findByUser(String id) {
//        User user = elasticsearchOperations.get(id, User.class);
        User user = new User();
        return Optional.ofNullable(user);
    }

    @Override
    public SearchHits<User> queryAllUsers() {
//        SearchHits<User> search = elasticsearchOperations.search(Query.findAll(), User.class);
        return null;
    }
}
