package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by BH00350 on 2015/12/10.
 */
//Serializable序列化这个接口比较特殊，没有抽象方法
//alt + inset 快捷键可以创建构造方法及..
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Word implements Serializable{
    private Integer id;
    private String english;
    private String chinese;

   /* public Word() {
    }

    public Word(Integer id, String english, String chinese) {
        this.id = id;
        this.english = english;
        this.chinese = chinese;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }*/
}
/*
1、序列化是干什么的？
       简单说就是为了保存在内存中的各种对象的状态（也就是实例变量，不是方法），
       并且可以把保存的对象状态再读出来。虽然你可以用你自己的各种各样的方法来保存object states，
       但是Java给你提供一种应该比你自己好的保存对象状态的机制，那就是序列化。
2、什么情况下需要序列化
    a）当你想把的内存中的对象状态保存到一个文件中或者数据库中时候；
    b）当你想用套接字在网络上传送对象的时候；
    c）当你想通过RMI传输对象的时候；
 */
