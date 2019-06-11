package java8新特性;


import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        //Sorted();
        //MapDemo();
        //MatchDemo();
        //countDemo();
        //reduceDemo();
        //stream串行和并行比较();


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


    /**
     * 中间操作 map 会将元素根据指定的 Function 接口来依次将元素转成另外的对象
     */
    public static  void MapDemo(){
        stringList.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("-------------------");
        stringList.stream().map(String::toUpperCase).sorted((a,b)-> b.compareTo(a)).forEach(System.out::println);
    }

    /**
     * Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。所有的匹配操作都是 最终操作 ，
     * 并返回一个 boolean 类型的值。
     */
    public static void MatchDemo(){
        boolean any = stringList.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println(any);
        boolean all = stringList.stream().allMatch(s -> s.startsWith("a"));
        System.out.println(all);
        boolean none = stringList.stream().noneMatch(s -> s.startsWith("a"));
        System.out.println(none);
    }


    /**
     * 计数是一个 最终操作，返回Stream中元素的个数，返回值类型是 long
     */
    public static  void countDemo(){
        long b = stringList.stream().filter(s -> s.startsWith("b")).count();
        System.out.println(b);
    }

    /**
     * 这是一个 最终操作 ，允许通过指定的函数来讲stream中的多个元素规约为一个元素，规约后的结果是通过Optional 接口表示的：
     */
    public static void  reduceDemo(){
        Optional<String> reduce = stringList.stream().reduce((s1, s2) -> s1 + "#" + s2);
        //reduce.ifPresent(System.out::println);
        String s = reduce.toString();
        System.out.println(reduce.get());


        //stream demo

        //// 字符串连接，concat = "abc"
        String concat  = Stream.of("a", "b", "c").reduce("", String::concat);
        System.out.println(concat );

        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);

        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);

        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);

        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat);
    }


    /**前面提到过Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行。
     *唯一需要做的改动就是将 stream() 改为parallelStream()。
     */
    private static void stream串行和并行比较() {
        //首先我们创建一个没有重复元素的大表：
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        //我们分别用串行和并行两种方式对其进行排序，最后看看所用时间的对比。
        //Sequential Sort(串行排序)
        //串行排序
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        //Parallel Sort(并行排序)
         t0 = System.nanoTime();
         count = values.parallelStream().sorted().count();
        System.out.println(count);
         t1 = System.nanoTime();
         millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));

    }

}
