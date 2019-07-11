package 简单的socketClientAndserver.单向通信;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: fang
 * @Date: 2019/7/11 21:31
 * @Description:
 */
public class ClientDemo {

    public static void main(String[] args)  throws  Exception{

        Socket socket =new Socket("127.0.0.1",9999);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello kitty".getBytes());
        outputStream.flush();
        outputStream.close();
        socket.close();


    }

}
