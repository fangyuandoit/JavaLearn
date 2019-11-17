package 手写源码系列.ArrayListPackage;

import java.util.Arrays;

/**
 * @Author: fang
 * @Date: 2019/11/16 15:16
 * @Description:
 */
public class MyArrayListTest {

    public static void main(String[] args) {

        MyArrayList<String> list = new MyArrayList();

        int count = 5;


        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        list.remove(1);

        for (int i = 0; i < count; i++) {
            System.out.println(list.get(i));
        }




    }

}
