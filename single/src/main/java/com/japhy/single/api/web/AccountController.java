package com.japhy.single.api.web;

import com.japhy.single.application.converter.UserConverter;
import com.japhy.single.domain.account.entity.User;
import com.japhy.single.domain.account.repository.sample.datajpa.UserCrudRepository;
import com.japhy.single.domain.account.repository.sample.datajpa.UserJpaRepository;
import com.japhy.single.domain.account.repository.sample.datajpa.UserPagingRepository;
import com.japhy.single.domain.account.repository.sample.datajpa.UserRepository;
import com.japhy.single.domain.account.repository.sample.jpa.UserAnnotationInterfaceRepository;
import com.japhy.single.api.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @date 2019/12/30 23:46
 */
@RestController
@Api(tags = "账户信息")
@RequestMapping("api/v1/account")
@Slf4j
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserPagingRepository userPagingRepository;

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserAnnotationInterfaceRepository userAnnotationInterfaceRepository;

    @GetMapping("/list")
    @ApiOperation(value = "账户信息", notes = "根据昵称查询用户信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = UserDTO.class, message = "success")
    })
    public ResponseEntity<?> queryUsersByNickName(
            @ApiParam(value = "昵称", required = true) @RequestParam @NotBlank String nickName,
            @ApiParam(value = "每页数量", required = true) @RequestParam @Positive Integer pageSize,
            @ApiParam(value = "页码", required = true) @RequestParam @Positive Integer pageNo) {

        Sort sort = Sort.by(Direction.DESC, "id");
        PageRequest page = PageRequest.of(pageSize, pageNo, sort);
        Page<User> users = userJpaRepository.queryAllByNickNameContains(nickName, page);
        log.info("pageable user:  -----  {}", users);

        ThreadLocalRandom random = ThreadLocalRandom.current();
        Set<Long> userIdSet = Stream.generate(() -> random.nextLong(20)).limit(14)
                .collect(Collectors.toSet());
        Iterable<User> allById = userCrudRepository.findAllById(userIdSet);
        log.info("crud reposty --- {}", allById);

        Page<User> userJpa = userPagingRepository.findAll(page);
        log.info("pageable user:  -----  {}", userJpa);

        List<User> byNickName = userAnnotationInterfaceRepository.findByNickName(nickName);
        log.info("annotation users: --- {}", byNickName);
        List<User> usersRepo = userRepository.queryAllByNickNameContains(nickName);
        log.info("repository users: --- {}", usersRepo);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存用户")
    @ApiResponses({
            @ApiResponse(code = 200, response = ResponseEntity.class, message = "success")
    })
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserDTO userDto) {
        UserConverter converter = new UserConverter();
        User user = converter.convertFromDto(userDto);
//        throw new CustomException();
        User save = userCrudRepository.save(user);
        return ResponseEntity.ok(save);
    }
}
