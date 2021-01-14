package com.japhy.single.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Japhy
 * @date 2019/12/30 23:47
 */
@ApiModel(description = "考试设置页面请求参数")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机", required = true)
    @NotBlank
    private String phone;

    @ApiModelProperty(value = "头像", required = true)
    private String avatar;

}
