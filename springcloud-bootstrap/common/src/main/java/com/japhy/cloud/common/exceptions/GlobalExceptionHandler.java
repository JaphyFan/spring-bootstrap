package com.japhy.cloud.common.exceptions;

import com.japhy.cloud.common.dto.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Japhy
 * @since 2022/1/18 13:15
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public @ResponseBody
    ApiError handleBadRequestException(ServerHttpRequest request, BadRequestException ex) {

        return createApiError(HttpStatus.BAD_REQUEST, request, ex);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody
    ApiError handleNotFoundException(ServerHttpRequest request, BadRequestException ex) {

        return createApiError(HttpStatus.NOT_FOUND, request, ex);
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InvalidInputException.class)
    public @ResponseBody
    ApiError handleInvalidInput(ServerHttpRequest request, BadRequestException ex) {

        return createApiError(HttpStatus.UNPROCESSABLE_ENTITY, request, ex);
    }

    private ApiError createApiError(
            HttpStatus httpStatus, ServerHttpRequest request, Exception ex) {
        final String path = request.getURI().getPath();
        final String message = ex.getMessage();

        log.debug("Returning HTTP status: {} for path: {}, message: {}", httpStatus, path, message);

        return ApiError.builder().status(httpStatus).msg(message).description(path).build();
    }
}
