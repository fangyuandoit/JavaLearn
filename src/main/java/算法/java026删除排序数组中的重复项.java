package 算法;

/**
 * @Author: fang
 * @Date: 2020/4/16 22:11
 * @Description:
 */
public class java026删除排序数组中的重复项 {

    public static void main(String[] args) {

        int nums[] =new int []{1,1,2};
        System.out.println(demo(nums));

    }

    //把更大的值赋值到前面来
    private static int demo(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        int size=0;
        for (int i = 1; i < nums.length; i++) {
               if(nums[size]==nums[i]){
               }else{
                   size++;
                   nums[size]=nums[i];
               }
        }
          return size+1;
    }


}
