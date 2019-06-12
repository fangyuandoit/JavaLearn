package java8新特性;

/**
 * @Author: fang
 * @Date: 2019/6/12 21:52
 * @Description:
 * default 关键字向接口添加非抽象方法实现
 *
 * 接口中除了抽象方法计算接口公式还定义了默认方法 sqrt。 实现该接口的类只需要实现抽象方法 calculate。 默认方法sqrt 可以直接使用
 */
public interface 接口的默认方法 {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        接口的默认方法 m =new 接口的默认方法() {
            @Override
            public double calculate(int a) {
                return  sqrt(a);
            }
        };
        System.out.println(m.calculate(100));     // 100.0
        System.out.println(m.sqrt(16));           // 4.0


    }


}
