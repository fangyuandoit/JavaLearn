package java8新特性;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: fang
 * @Date: 2019/6/5 20:53
 * @Description:
 * Java 8扩展了集合类，可以通过 Collection.stream() 或者 Collection.parallelStream() 来创建一个Stream
 *
 */
public class Streams {

    static List<String> stringList = new ArrayList<String>();
    static{
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
    }

    public static void main(String[] args) {
      //  foreachdemo();
       // filterDemo();
        Sorted();

    }


    public  static void foreachdemo(){
        stringList.forEach(s -> System.out.println(s));
        System.out.println("------------");
        stringList.forEach(System.out::println);
    }

    /**
     * 过滤通过一个predicate接口来过滤并只保留符合条件的元素，
     * 该操作属于中间操作，所以我们可以在过滤后的结果来应用其他Stream操作（比如forEach）。
     * forEach需要一个函数来对过滤后的元素依次执行。
     * forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。
     */
    public static  void filterDemo(){
        stringList.stream().filter(s->s.startsWith("a")).forEach(s-> System.out.println(s));
    }

    /**
     * 排序是一个 中间操作，返回的是排序好后的 Stream。
     * 如果你不指定一个自定义的 Comparator 则会使用默认排
     *
     * 排序只创建了一个排列好后的Stream，而不会影响原有的数据源
     */
    public static void Sorted(){
        stringList.stream().sorted().forEach(System.out::println);
        System.out.println(stringList);
        List<String> collect = stringList.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
    }


}
