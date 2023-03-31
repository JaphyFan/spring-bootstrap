package com.japhy.bootstrap.sharding.api;

import com.japhy.bootstrap.sharding.entity.User;
import com.japhy.bootstrap.sharding.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/11/30 16:57
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserApi {

    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody List<User> userList) {
        userRepository.saveAll(userList);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> listAll() {
        List<User> all = userRepository.findAll();
        return ResponseEntity.ok(all);
    }

}
