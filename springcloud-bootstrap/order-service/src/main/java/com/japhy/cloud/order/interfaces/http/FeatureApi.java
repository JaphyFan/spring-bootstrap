package com.japhy.cloud.order.interfaces.http;

import com.japhy.cloud.order.application.dto.UserDto;
import com.japhy.cloud.order.application.service.FeatureService;
import com.japhy.cloud.order.application.service.impl.FeignFeatureService;
import io.swagger.v3.oas.annotations.Operation;
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
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2022/1/21 17:03
 */
@RestController
@RequestMapping("api/v1/features")
@RequiredArgsConstructor
@Tag(name = "特性实验接口")
@Slf4j
public class FeatureApi {

    private final FeatureService featureService;

    @GetMapping("/delay/{time}")
    @Operation(summary = "order service", description = "find order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found")})
    public ResponseEntity<List<UserDto>> delay(@PathVariable("time") Long time) {
        return ResponseEntity.ok(featureService.delay(time));
    }

}
