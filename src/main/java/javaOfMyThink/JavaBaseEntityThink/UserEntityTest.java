package javaOfMyThink.JavaBaseEntityThink;

import com.alibaba.fastjson.JSON;

/**
 * @Author: fang
 * @Date: 2019/11/15 21:37
 * @Description:
 */
public class UserEntityTest {

    public static void main(String[] args) {

        UserEntity userEntity = new UserEntity().builder().id(1).name("jack").gender("man").build();
        System.out.println(userEntity.toString());
        System.out.println(userEntity.toJsonString());
    }
}
