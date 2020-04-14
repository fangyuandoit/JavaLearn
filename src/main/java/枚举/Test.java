package 枚举;

/**
 * @Author: fy fangyuan@i-soon.net
 * @Date: 2019/11/26 17:40
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        System.out.println(DealStatus.DOWNING.getStatus());
        System.out.println(DealStatus.PREVIEWED);


        System.out.println(ServerType.MYSQL.getName());
        System.out.println(ServerType.MYSQL.getType());




    }
}
