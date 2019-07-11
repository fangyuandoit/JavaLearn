package 简单的socketClientAndserver.服务端优化;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @Author: fang
 * @Date: 2019/7/11 22:07
 * @Description:
 */
public class 服务端阻塞 {


    public static void main(String[] args)  throws  Exception{


        ServerSocket serverSocket =new ServerSocket(9999);
        System.out.println("start server ing");
        while(true){
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            String s = IOUtils.toString(inputStream, "utf-8");
            System.out.println(s);

            inputStream.close();
            accept.close();

            TimeUnit.SECONDS.sleep(1);

        }




    }

}
