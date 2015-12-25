package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/13.
 */
//模型类  有两种方法创建
// 1、传统的文件里定义域及相应的setter方法
// 2、使用注解方式@。。。步骤如下1）在类前放@Data @AllArgsConstructor @NoArgsConstructor  2）setting，plugins，lombok，install plugin,重启idea  3）setting，Build。。compiler，Annotation Process，Enable Annotation Process
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;

    /*//传统的文件里定义域及相应的setter方法
    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/
}
