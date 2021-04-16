package com.japhy.bootstrap.web.domain.order.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Japhy
 * @since 2021/1/10 20:48
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderParam{

    private String orderNo;

    @DateTimeFormat(style = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private LocalDate date;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date testDate;
}
