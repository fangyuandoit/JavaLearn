package javaOfMyThink.JavaBaseEntityThink;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: fang
 * @Date: 2019/11/15 21:35
 * @Description:
 */
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class UserEntity extends BaseEntity {

    private int id;
    private String name;
    private String gender;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public UserEntity(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }


    public UserEntity() {
    }
}
