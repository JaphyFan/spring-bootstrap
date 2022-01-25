package com.japhy.cloud.user.interfaces.http;

import com.japhy.cloud.user.application.dto.UserDto;
import com.japhy.cloud.user.application.mapper.UserDtoMapper;
import com.japhy.cloud.user.application.service.UserFacade;
import com.japhy.cloud.user.domain.entity.User;
import com.japhy.cloud.user.domain.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2022/1/21 15:32
 */
@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Tag(name = "用户信息接口")
@Slf4j
public class UserApi {

    private final UserFacade userFacade;

    @GetMapping("/{userId}")
    @Operation(summary = "order service", description = "find order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found")})
    public ResponseEntity<UserDto> getUserByOrderId(
            @Parameter(name = "userId", required = true) @PathVariable Long userId) {
        return ResponseEntity.ok(userFacade.getUserById(userId));
    }

}
