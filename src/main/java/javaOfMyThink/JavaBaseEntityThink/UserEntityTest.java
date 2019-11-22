package javaOfMyThink.JavaBaseEntityThink;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fang
 * @Date: 2019/11/15 21:37
 * @Description:
 */
public class UserEntityTest {

    public static void main(String[] args) {

//        UserEntity userEntity = new UserEntity().builder().id(1).name("jack").gender("man").build();

        UserEntity userEntity =new UserEntity(1,"man","jack");
        System.out.println(userEntity.toString());
//        System.out.println(userEntity.toJsonString());



//        List list =new ArrayList();
//        list.add(userEntity);
//
//
//        System.out.println(list.contains(userEntity));
//        System.out.println(list.contains(new UserEntity(1,"man","jack")));
//
//
//        System.out.println(userEntity.getClass());
//
//        System.out.println(System.identityHashCode(userEntity));

    }
}
