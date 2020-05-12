package 算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: fang
 * @Date: 2020/4/13 22:25
 * @Description:
 */
public class java001两数之和 {

    public static void main(String[] args) {
           int [] nums =new int[]{2, 7, 8, 9};
           int target=15;

        System.out.println(Arrays.toString(传统双重for循环方式(nums,target)));
        System.out.println(Arrays.toString(两遍hash存值(nums,target)));

        System.out.println(Arrays.toString(一遍hash存值(nums,target)));

    }

    private static int[] 两遍hash存值(int[] nums, int target) {
               Map<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
              map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
             int integer = nums[i];
            int expect = target-integer;
            if(map.containsKey(expect)){
                 return new int[]{i,map.get(expect)};
            }
        }
 return null;
    }

    //利用map保存当前值，这个过程中如果遇见等式成立的期望值，就是需要的数值
    private static int[] 一遍hash存值(int[] nums, int target) {
        Map<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expect = target-nums[i];
            if(map.containsKey(expect)){
                return new int[]{i,map.get(expect)};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public  static  int[] 传统双重for循环方式(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                  if(target==nums[i]+nums[j] && i!=j){
                         return new int []{i,j};
                  }
            }
        }
        return null;
    }

}
