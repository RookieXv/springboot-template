package com.liuwenxu.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: Form
 * Author: liuwenxu
 * Date: 2020-9-22 15:49:41
 * Description: 表单表 实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Form对象", description="表单表")
public class Form implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "表单名")
    private String title;

    @ApiModelProperty(value = "表单配置")
    private String formConfig;

    @ApiModelProperty(value = "表单数据")
    private String formData;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime creatTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
