package com.japhy.cloud.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * 程序异常时返回的信息.
 *
 * @author Japhy
 * @since 2020/4/18 22:59
 */
@ToString
@Getter
@Builder
public class ApiError {

    /**
     * http 状态码
     */
    @Schema(description = "http 状态码")
    private HttpStatus status;

    /**
     * 返回前端用户的错误信息
     */
    private String msg;

    /**
     * zipkin 使用的traceId
     */
    @Schema(description = "zipkin 使用的traceId")
    private String traceId;

    /**
     * 时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

    /**
     * 开发查看的错误信息
     */
    private String description;

    /**
     * 业务错误
     */
    private List<ErrorItem> errors;

    /**
     * Post,put,patch 语义使用 例如参数校验
     */
    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class ErrorItem {

        /**
         * 业务码
         */
        private int code;

        /**
         * 参数错误信息
         */
        private String msg;

        /**
         * 某个参数
         */
        private String field;

    }

}
