package 算法;

/**
 * @Author: fang
 * @Date: 2020/4/16 21:33
 * @Description:      反转依然相等，即为回文数字
 */
public class java002回文数字 {

    public static void main(String[] args) {


        System.out.println(32/10);

        int x = 1234321;

        System.out.println(字符串反转(x));
        System.out.println(反转后半部分数字(x));
    }

    private static boolean 反转后半部分数字(int x) {

        if(x < 0 ||  x % 10==0 && x != 0){
                return false;
        }
           int reverseNum=0;
         while(x>reverseNum){
                  reverseNum = reverseNum*10 +  x%10;
                  x = x/10;
         }
        return x==reverseNum || x==reverseNum/10;

    }

    private static boolean 字符串反转(int x) {
        StringBuffer stringBuffer =new StringBuffer(String.valueOf(x));
        String s = stringBuffer.reverse().toString();
        if(s.equals(x+"")){
             return true;
        }else{
            return false;
        }
    }


}
