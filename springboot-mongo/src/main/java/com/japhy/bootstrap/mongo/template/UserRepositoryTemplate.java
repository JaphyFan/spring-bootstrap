package com.japhy.bootstrap.mongo.template;

import com.japhy.bootstrap.mongo.User;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Japhy
 * @since 2023/4/12 17:54
 */
@Repository
public class UserRepositoryTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void deleteAll() {
        mongoTemplate.remove(User.class).all();
    }

    public long countAll() {
        return mongoTemplate.count(new Query(), User.class);
    }

}
