package 简单的socketClientAndserver.单向通信;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: fang
 * @Date: 2019/7/11 21:26
 * @Description:
 */
public class ServerDemo {

    public static void main(String[] args) throws  Exception {

        ServerSocket serverSocket =new ServerSocket(9999);
        System.out.println("server将一直等待连接的到来");

        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        String info = IOUtils.toString(inputStream, "utf-8");
        System.out.println(info);
        inputStream.close();
        accept.close();
        serverSocket.close();


    }

}
