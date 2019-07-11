package 简单的socketClientAndserver.双向通信;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Author: fang
 * @Date: 2019/7/11 21:41
 * @Description:
 */
public class ServerDemo {


    public static void main(String[] args)  throws Exception{

        ServerSocket serverSocket =new ServerSocket(9999);
        System.out.println("start server ing");
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        String info = IOUtils.toString(inputStream, "utf-8");
        System.out.println(info);

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write((new Date()+"").getBytes());

        outputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();


    }


}
