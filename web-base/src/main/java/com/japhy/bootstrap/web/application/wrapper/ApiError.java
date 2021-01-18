package com.japhy.bootstrap.web.application.wrapper;

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
public class ApiError {

    /**
     * http 状态码
     */
    private int status;

    /**
     * 返回前端用户的错误信息
     */
    private String msg;

    /**
     * zipkin 使用的trackId
     */
    private String traceId;

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
