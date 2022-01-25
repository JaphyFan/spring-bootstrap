package com.japhy.cloud.order.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Japhy
 * @since 2022/1/18 14:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private Integer orderId;

    private String orderName;

    private BigDecimal price;

    private LocalDateTime createTime;

    private String customName;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date testDateWitJsonFormat;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateWithBoth;

    private Date dateWithout;
}
