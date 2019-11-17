package 手写源码系列.HashmapPackage;

/**
 * @Author: fang
 * @Date: 2019/10/23 22:22
 * @Description:
 */
public class MyHashMapTest {

    public static void main(String[] args) {

        MyHashMap<String ,String> map =new MyHashMap<>();

        for (int i = 0; i < 10; i++) {

            map.put(i+"",i+"");
        }

        System.out.println(map.get(""));


    }

}
