package com.japhy.bootstrap.web.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Japhy
 * @since 2021/1/11 15:23
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Schema(description = "order dto")
@Data
public class OrderDto {

    public  Long id;

    private String orderNo;

    private Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Schema(name = "创建时间", example = "2021-09-01 11:00:00")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private Long operatorId;

    private Integer status;

}
