package com.pg.generate.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TablesSchema implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字段名称")
    private String columnName;

    @ApiModelProperty(value = "字段类型")
    private String dataType;

    @ApiModelProperty(value = "字段长度")
    private String characterMaximumLength;

    @ApiModelProperty(value = "字段编码")
    private String collationName;

    @ApiModelProperty(value = "字段描述")
    private String columnComment;
}
