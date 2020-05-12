package 算法;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: fang
 * @Date: 2020/4/26 22:52
 * @Description:
 */
public class java003无重复字符的最长子串 {


    public static void main(String[] args) {


        System.out.println(new java003无重复字符的最长子串().lengthOfLongestSubstring(" "));
        System.out.println(new java003无重复字符的最长子串().滑动的伸缩尺子("abcabcbb"));
        System.out.println(new java003无重复字符的最长子串().左端跳跃性尺子("abba"));




    }

    /**
     * 暴力方法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0){
              return 0;
        }
        int size=0;

        for( int i =0;i<s.length();i++){

            String sAppend = s.substring(i);

            char[] chars = sAppend.toCharArray();
            String temp ="";
            for (char c : chars) {
                if(temp.contains(c+"")){
                    size = Math.max(size,temp.length());
                    break;
                }else{
                    temp = temp+c;
                    size = Math.max(size,temp.length());
                }
            }
        }
        return size;
    }


    /**
     * 假设有一把可伸缩的尺子（hashset）在这个字符串上滑动
     * 从左向右滑动，如果这个尺子不存在相同的值，那么尺子的右端长一位，如果存在相同的值，那么尺子左边短一位。
     * @param s
     * @return
     */
    public int 滑动的伸缩尺子(String s ){

        int n = s.length();
        int result=0 ,i=0 ,j=0;
        HashSet<Character> set =new HashSet<>();
        while(i<n && j<n){

            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;

            }else{
                set.add(s.charAt(j));
                j++;
                result = Math.max(result,j-i);
            }
        }
        return result;
    }


    /**
     * 假设有一把可伸缩的尺子（hashmap）在这个字符串上滑动
     *  从左向右滑动，如果这个尺子不存在相同的值，那么尺子的右端长一位，如果存在相同的值，那么左端需要向右位移到重复的数值
     * @param s
     * @return
     */
    public  int 左端跳跃性尺子(String s ){
        int result =0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0,j=0;j<s.length();j++){
              if(map.containsKey(s.charAt(j))){
                  i=Math.max(map.get(s.charAt(j)),i);   // 因为hashmap里面的数去没有remove。所以遇到重复的数的时候，需要找到较大的哪一个
              }
              result =Math.max(result,j-i+1);
              map.put(s.charAt(j),j+1);
        }

        return result;
    }

}
