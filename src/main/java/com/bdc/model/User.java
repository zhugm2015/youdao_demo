package com.bdc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by BH00350 on 2015/12/29.
 */

//模型类  有两种方法创建
// 1、传统的文件里定义域及相应的setter方法
// 2、使用注解方式@。。。步骤如下1）在类前放@Data @AllArgsConstructor @NoArgsConstructor
// 2）setting，plugins，lombok，install plugin,重启idea
// 3）setting，Build。。compiler，Annotation Process，Enable Annotation Process

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseModel {
    private Integer id;
    private String username;
    private String password;
}
