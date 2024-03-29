package com.japhy.cloud.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 程序异常时返回的信息.
 *
 * @author Japhy
 * @since 2020/4/18 22:59
 */
@ToString
@Getter
@Builder
public class ApiError implements Serializable {

    private static final long serialVersionUID = -6450263528088986251L;

    /**
     * 状态码，可自定义
     */
    @Schema(description = "状态码，可自定义")
    private int errorCode;

    /**
     * 返回前端用户的错误信息
     */
    @Schema(description = "返回前端用户的错误信息")
    private String msg;

    /**
     * http 状态码
     */
    private Integer statusCode;

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
    public static class ErrorItem implements Serializable {

        private static final long serialVersionUID = -8913037090435188823L;

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
