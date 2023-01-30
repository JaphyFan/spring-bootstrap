package com.japhy.servlet.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Japhy
 * @since 2021/4/12 17:03
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidationDto {

    @NotEmpty
    private String name;

    @Max(150)
    private Long age;

    @Digits(integer = 1, fraction = 1)
    private BigDecimal money;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate localDate;

}
