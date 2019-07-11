package 简单的socketClientAndserver.双向通信;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: fang
 * @Date: 2019/7/11 21:48
 * @Description:
 */
public class ClientServer {

    public static void main(String[] args)  throws  Exception{

        Socket socket =new Socket("127.0.0.1",9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("what color".getBytes());

        //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        String info = IOUtils.toString(inputStream, "utf-8");
        System.out.println(info);

        inputStream.close();
        outputStream.close();
        socket.close();


    }

}
