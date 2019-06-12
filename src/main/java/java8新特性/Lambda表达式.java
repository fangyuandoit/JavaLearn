package java8新特性;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: fang
 * @Date: 2019/6/12 22:05
 * @Description:
 */
public class Lambda表达式 {

    public static void main(String[] args) {
        排列字符串();

    }

    public  static  void 排列字符串(){

        //首先看看在老版本的Java中是如何排列字符串的：
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(names);

        //lambda表达式
        Collections.sort(names,(String a ,String b) ->{
             return b.compareTo(a);
        });
        System.out.println(names);

        names.sort((a,b)->a.compareTo(b));
        System.out.println(names);

    }

}
