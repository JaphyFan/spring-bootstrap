package com.japhy.bootstrap.web.interfaces.http;

import com.japhy.bootstrap.web.application.event.publisher.OrderCreatedEventPublisher;
import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.domain.user.entity.User;
import com.japhy.bootstrap.web.infrastructure.annotations.LogExecutionTime;
import com.japhy.bootstrap.web.interfaces.dto.UserVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Japhy
 * @since 2021/1/25 16:48
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/features")
@Tag(name = "demonstrate some features")
public class FeatureApi {

    @Setter
    private OrderCreatedEventPublisher publisher;

    @GetMapping("/filter")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/docker")
    public ResponseEntity<String> docker() {
        return ResponseEntity.ok("docker start");
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/roles")
    public ResponseEntity<String> role() {
        return ResponseEntity.ok("admin role test");
    }

    @LogExecutionTime
    @Operation(summary = "test get array param", description = "@RequestParam will automatically split dot separated string")
    @GetMapping("/testArray")
    ResponseEntity<List<String>> testArray(@Parameter @RequestParam List<String> orderNos) {
        UserVo.builder().jwtToken("d").build();
        return ResponseEntity.ok(orderNos);
    }

    @GetMapping("/async")
    public ResponseEntity<String> async() {
        publisher.publishEvent(new Order());
        return ResponseEntity.ok("async test");
    }

    @GetMapping("/optional")
    public ResponseEntity<String> optional(@Parameter @RequestParam(required = false) String test) {
        return ResponseEntity.notFound().build();
    }

    /**
     * 使用 @ParameterObject可以直接映射pageable参数.
     *
     * @param name
     * @param pageable
     * @return
     */
    @Operation(summary = "pageable ")
    @GetMapping("/page")
    public ResponseEntity<String> getOrder(@RequestParam String name,
                                           @ParameterObject Pageable pageable) {

        return ResponseEntity.ok(name);
    }

    @Operation(summary = "api demo")
    @Parameters({
            @Parameter(name = "name", description = "name"),
            @Parameter(name = "pageable", description = "pageable", schema = @Schema(implementation = Pageable.class))
    })
//    返回数组形式的user,当只有一个返回体时可以不写
//    @ApiResponse(responseCode = "200", description = "请求成功", content = @Content(array = @ArraySchema(schema = @Schema(implementation = User.class))))
    @GetMapping("/api/{age}")
    public ResponseEntity<User> apiDemo(@RequestParam String name,@PathVariable Long age,
                                          @ParameterObject Pageable pageable) {
        return ResponseEntity.noContent().build();
    }

}
