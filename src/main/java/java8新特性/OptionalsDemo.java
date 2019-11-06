package java8新特性;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: fang
 * @Date: 2019/6/12 22:13
 * @Description:
 */
public class OptionalsDemo {

    public static void main(String[] args) {

//        demo1();
//        判断字符串是否为null();
        判断List否为null();

    }


    public static void  判断字符串是否为null(){

        String notNullString = "check";
        String nullString = null;

        System.out.println(Optional.ofNullable(notNullString).orElse("").length());
        System.out.println(Optional.ofNullable(nullString).orElse("").length());



    }


    public static void  判断List否为null(){

        List<String> nullList =null;

        List<String> notNull =new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            notNull.add(i+"");
        }


        Optional.ofNullable(nullList).orElse(new ArrayList<>()).forEach(o -> {
            System.out.println(o);
        });


        System.out.println("-----------");

        Optional.ofNullable(notNull).orElse(new ArrayList<>()).forEach(o -> {
            System.out.println(o);
        });

    }


    public static void demo1(){

        //of（）：为非null的值创建一个Optional
        Optional<String> optional = Optional.of("bam");
// isPresent（）： 如果值存在返回true，否则返回false
        optional.isPresent();           // true
//get()：如果Optional有值则将其返回，否则抛出NoSuchElementException
        optional.get();                 // "bam"
//orElse（）：如果有值则将其返回，否则返回指定的其它值
        optional.orElse("fallback");    // "bam"
//ifPresent（）：如果Optional实例有值则为其调用consumer，否则不做处理
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"

    }

}
