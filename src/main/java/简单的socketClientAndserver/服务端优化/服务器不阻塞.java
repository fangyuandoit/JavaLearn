package 简单的socketClientAndserver.服务端优化;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: fang
 * @Date: 2019/7/11 22:17
 * @Description:
 */
public class 服务器不阻塞 {


    public static void main(String[] args)  throws Exception {

        ExecutorService threadPool = Executors.newFixedThreadPool(100);

        System.out.println("start servering");
        ServerSocket serverSocket =new ServerSocket(9999);
        while(true){

            Socket accept = serverSocket.accept();

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = accept.getInputStream();
                        String s = IOUtils.toString(inputStream, "utf-8");
                        System.out.println(s);

                        inputStream.close();
                        accept.close();
                        TimeUnit.SECONDS.sleep(1);


                    }catch ( Exception  e){
                        e.printStackTrace();
                    }
                }
            });
        }

    }

}
