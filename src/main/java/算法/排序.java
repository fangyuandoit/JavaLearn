package 算法;

import java.util.Arrays;

/**
 * @Author: fang
 * @Date: 2020/4/16 21:14
 * @Description:
 */
public class 排序 {

    public static void main(String[] args) {

        int arr[] = new int[]{1,6,3,2,5,8,7,9,4,6,8,2};
        冒泡(arr);
        选择排序(arr);
        插入排序(arr);
        简单桶排序(arr);

    }

    /**
     * 桶排序
     * 有一个从小到刀的通，0房0桶，5放5桶。如果桶里面已经有元素了，里面的值自加一即可
     * @param arr
     */
    private static void 简单桶排序(int[] arr) {

        int[] buckets =new int[arr.length+1];
        for (int i : arr) {
             buckets[i]++;
        }
        for (int i = 0; i < buckets.length; i++) {
            for(int j =0;j<buckets[i];j++){
                System.out.print(i  +" ,");
            }
        }


    }

    private static void 插入排序(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
                  int temp = arr[i];
                  int index = i;
                  while(arr[i-1]>temp){
                       arr[i] = arr[i-1];
                       i--;
                       if(i==0){
                           break;
                       }
                  }
                  arr[index]=temp;
        }

        System.out.println(Arrays.toString(arr));

    }

    private static void 选择排序(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            int max=arr[0];
            int index=0;
            for (int j = 0; j < arr.length-i; j++) {
                   if(arr[j]>max){
                        max=arr[j];
                        index = j;
                   }
            }
            int t = arr[index];
            arr[index] = arr[arr.length-i-1];
            arr[arr.length-i-1]=t;
        }

        System.out.println(Arrays.toString(arr));

    }

    private static void 冒泡(int[] arr) {
             int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                  if(arr[j]>arr[j+1]){
                         temp = arr[j];
                         arr[j] = arr[j+1];
                         arr[j+1] = temp;
                  }
            }
        }
        System.out.println(Arrays.toString(arr));

    }


}
