package com.japhy.cloud.user.interfaces.http;

import com.google.common.collect.Lists;
import com.japhy.cloud.user.application.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2022/1/21 16:09
 */
@RestController
@RequestMapping("api/v1/features")
@RequiredArgsConstructor
@Tag(name = "New Features")
@Slf4j
public class FeatureApi {

    @GetMapping("/delay/{time}")
    @Operation(summary = "order service", description = "find order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found")})
    public ResponseEntity<List<UserDto>> delay(@PathVariable("time") Long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("InterruptedException");
        }
        return ResponseEntity.ok(Lists.newArrayList(UserDto.builder().name("hello").build()));
    }

    @GetMapping("/faultPercent/{percent}")
    @Operation(summary = "order service", description = "find order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found")})
    public ResponseEntity<Void> getUserByOrderId(@PathVariable("percent") Long percent) {
        return ResponseEntity.ok().build();
    }

}
