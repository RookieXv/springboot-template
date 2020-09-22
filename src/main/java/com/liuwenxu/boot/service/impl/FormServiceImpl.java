package com.liuwenxu.boot.service.impl;

import com.liuwenxu.boot.entity.Form;
import com.liuwenxu.boot.mapper.FormMapper;
import com.liuwenxu.boot.service.IFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: FormServiceImpl
 * Author: liuwenxu
 * Date: 2020-9-22 15:49:41
 * Description: 表单表 服务实现类
 */
@Service
public class FormServiceImpl extends ServiceImpl<FormMapper, Form> implements IFormService {

}
