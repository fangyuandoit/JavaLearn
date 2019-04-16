package java并发编程实战.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: fang
 * @Date: 2019/4/16 21:22
 * @Description:
 */
public class TestAtomic {

    public static void main(String[] args) {

        AtomicInteger count =new AtomicInteger();

        System.out.println(count.getAndIncrement());
        System.out.println(count.getAndIncrement());
        System.out.println(count.get());

    }

}
