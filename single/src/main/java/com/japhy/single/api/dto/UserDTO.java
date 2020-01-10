package com.japhy.single.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Japhy
 * @date 2019/12/30 23:47
 */
@ApiModel
@Getter
@ToString
public class UserDTO {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机", required = true)
    @NotBlank
    private String phone;

    @ApiModelProperty(value = "头像", required = true)
    private String avatar;

}
