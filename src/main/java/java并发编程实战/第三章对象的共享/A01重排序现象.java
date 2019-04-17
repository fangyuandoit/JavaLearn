package java并发编程实战.第三章对象的共享;

/**
 * @Author: fang
 * @Date: 2019/4/17 22:12
 * @Description:
 */
public class A01重排序现象 {
     static int number  = 0;
    static   boolean ready = false;

    public static void main(String[] args) {


    new ReaderThread().start();
    number=42;
    ready = true;

    }

    private static class ReaderThread extends  Thread{
        @Override
        public void run() {
                 while(!ready){
                     Thread.yield();
                 }
            System.out.println(number);
        }

    }

}
