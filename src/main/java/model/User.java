package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/13.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//Ä£ÐÍÀà
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;

    /*public User() {
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
