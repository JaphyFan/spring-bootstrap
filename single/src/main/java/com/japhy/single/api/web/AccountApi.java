package com.japhy.single.api.web;

import com.japhy.single.api.dto.UserDTO;
import com.japhy.single.application.converter.UserConverter;
import com.japhy.single.domain.account.entity.User;
import com.japhy.single.domain.account.repository.sample.datajpa.UserCrudRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/1/4 10:29
 */
@RestController
@RequestMapping("api/v1/account")
@RequiredArgsConstructor
public class AccountApi {

    private final UserCrudRepository userCrudRepository;

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
