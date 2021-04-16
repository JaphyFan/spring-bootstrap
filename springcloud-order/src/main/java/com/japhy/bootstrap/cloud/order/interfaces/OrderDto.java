package com.japhy.bootstrap.cloud.order.interfaces;

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
 * @since 2021/4/2 03:31
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date testDateWitJsonFormat;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateWithBoth;

    private Date dateWithout;
}
