package 简单的socketClientAndserver.服务端优化;

import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

/**
 * @Author: fang
 * @Date: 2019/7/11 22:11
 * @Description:
 */
public class 客户端 {

    public static void main(String[] args) throws  Exception{


        for (int i =0;i<10;i++){
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     try {
                         Socket socket = new Socket("127.0.0.1",9999);
                         OutputStream outputStream = socket.getOutputStream();
                         outputStream.write((System.currentTimeMillis()+"").getBytes());
                         outputStream.close();
                         socket.close();
                     }catch (Exception e){
                         e.printStackTrace();
                     }
                 }
             }).start();

        }


    }

}
