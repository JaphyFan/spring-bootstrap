package com.japhy.bootstrap.web.interfaces.http;

import com.japhy.bootstrap.web.domain.user.entity.User;
import com.japhy.bootstrap.web.domain.user.service.UserService;
import com.japhy.bootstrap.web.infrastructure.config.WebSecureConfig;
import com.japhy.bootstrap.web.infrastructure.util.JwtUtil;
import com.japhy.bootstrap.web.infrastructure.util.WebUserDetailsService;
import com.japhy.bootstrap.web.interfaces.dto.AuthenticationRequest;
import com.japhy.bootstrap.web.interfaces.dto.CreateUserRequest;
import com.japhy.bootstrap.web.interfaces.dto.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/1/30 14:48
 */
@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
@Api("认证")
@ConditionalOnBean(value = WebSecureConfig.class)
public class AuthApi {

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private final WebUserDetailsService webUserDetailsService;

    private final UserService userService;

    @ApiOperation("登录认证")
    @PostMapping("/authenticate")
    public ResponseEntity<User> login(@RequestBody AuthenticationRequest authRequest) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),
                            authRequest.getPassword()));

            User user = (User) authenticate.getPrincipal();
            return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtUtil.generateToken(user))
                .body(user);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody CreateUserRequest user) {
        User user1 = userService.createUser(user);
        return ResponseEntity.ok(user1);
    }
}
