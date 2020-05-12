package 算法;

/**
 * @Author: fang
 * @Date: 2020/4/23 21:42
 * @Description:
 */
public class java007整数反转 {

    public static void main(String[] args) {

        System.out.println(new java007整数反转().reverse(-123));

    }

    /**
     * 听过%取模的方式获得最后一位,然后再自己除以10，在继续取模
     *
     * 注意反转后内存溢出
     * @param x
     * @return
     */
    public int reverse(int x) {

        int rev = 0;
        while(x!=0){
                  int  pop = x%10;
                  x = x/10;
                  if(rev > Integer.MAX_VALUE/10  || (rev ==Integer.MAX_VALUE && pop>7 )){
                          return 0;
                  }
                  if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE && pop < -8)){
                     return 0;
                  }
                  rev =rev*10 +pop;
        }
        return rev;
    }

}
