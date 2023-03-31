package com.japhy.hateoas.api;


import com.japhy.hateoas.UserNotFoundException;
import com.japhy.hateoas.api.assembler.UserModelAssembler;
import com.japhy.hateoas.model.entity.User;
import com.japhy.hateoas.model.enums.Status;
import com.japhy.hateoas.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/1/12 11:28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Slf4j
public class UserApi {

    private final UserRepository userRepository;

    private final UserModelAssembler userModelAssembler;

    private final PagedResourcesAssembler<User> pagedResourcesAssembler;

    @GetMapping
    public CollectionModel<EntityModel<User>> all() {
        List<User> all = userRepository.findAll();
        return userModelAssembler.toCollectionModel(all);
    }

    @GetMapping("/page")
    public ResponseEntity<?> page(Pageable page, String name) {
        Page<User> all = userRepository.findAll(page);
        PagedModel<EntityModel<User>> entityModels =
            pagedResourcesAssembler.toModel(all, userModelAssembler);
        log.info("name:" + name);
        return ResponseEntity.ok(entityModels);
    }

    @GetMapping("/{id}")
    public EntityModel<User> one(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return userModelAssembler.toModel(user);
    }

    @PostMapping
    public ResponseEntity<EntityModel<User>> newUser(@RequestBody User user) {
        EntityModel<User> userEntityModel = userModelAssembler.toModel(userRepository.save(user));
        return ResponseEntity
            .created(userEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(userEntityModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceUser(@RequestBody User user, @PathVariable Long id) {
        User user2 = userRepository.findById(id).map(user1 -> {
            user1.setStatus(user.getStatus());
            user1.setAge(user.getAge());
            user1.setName(user.getName());
            return userRepository.save(user1);
        }).orElseThrow(() -> new UserNotFoundException(id));

        EntityModel<User> userEntityModel = userModelAssembler.toModel(user2);
        return ResponseEntity.created(
            userEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(userEntityModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 选择传递json ，但是body中只填 "CREATED"
     * @param id
     * @param status
     * @return
     */
    @PatchMapping("/{id}/status")
    public ResponseEntity<?> changeStatus(@PathVariable Long id, @RequestBody Status status) {
        User user1 = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        if (user1.getStatus() == Status.DELETED) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE,
                    MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).body(
                    Problem.create().withTitle("Method not allowed")
                        .withDetail(" deleted user can't not change status to " + status));
        }

        user1.setStatus(status);
        return ResponseEntity.ok(userModelAssembler.toModel(userRepository.save(user1)));
    }
}
