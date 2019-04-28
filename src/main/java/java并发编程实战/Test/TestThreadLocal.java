package java并发编程实战.Test;

import java.util.Map;

/**
 * @Author: fang
 * @Date: 2019/4/23 22:07
 * @Description:
 */
public class TestThreadLocal {

    public static void main(String[] args) {


        ThreadLocal<Map<String,Object>> local =new ThreadLocal<>();


//        for(int i =0;i<3;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                     ThreadLocal<String>  threadLocal= new ThreadLocal<String>();
//                    threadLocal.set(System.currentTimeMillis()+"");
//                    System.out.println(threadLocal.get());
//                }
//            }).start();
//        }


    }


}
