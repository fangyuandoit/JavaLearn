package 算法;

import java.util.EmptyStackException;

/**
 * @Author: fang
 * @Date: 2020/4/21 22:34
 * @Description:
 */
public class java014最长公共前缀 {

    public static void main(String[] args) {

        java014最长公共前缀 demo =new java014最长公共前缀();

        String strs[] = new String[]{"flower", "flow", "flight"};
        String s = 依次遍历每个字符(strs);
        假设第一个为最长公共前缀(strs);
        System.out.println(demo.longestCommonPrefix(strs));

    }

    //假设第一个是最长公共子串，然后和其他做startwith判断。
    // 如果不满足，就把第一个最后一个字符截掉，再次比较。直到满足条件或者没有公共子串
    private static String  假设第一个为最长公共前缀(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        String result =strs[0];
        for (String str : strs) {
            while(!str.startsWith(result)){
                if(result.equals("")){
                      return result;
                }
                  result = result.substring(0,result.length()-1);
            }
        }
          return result;
    }

    /**
     * 从下标0开始，判断每一个字符串的下标0，判断是否全部相同。直到遇到不全部相同的下标。
     *
     * @return
     */
    private static String 依次遍历每个字符(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        //找到最短的子串
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            min = Math.min(min, str.length());
        }

        String result = "";

        for (int i = 0; i < min; i++) {
            boolean isEqual = true;
            char c = strs[0].charAt(i);

            for (String str : strs) {
                char tempchar = str.charAt(i);
                if (c != tempchar) {
                    isEqual = false;
                }
            }
            if (isEqual) {
                result = result + c;
            }else{
                return result;
            }
        }
        return result;
    }


    ///////////////////////////// start 分治

    public  String longestCommonPrefix(String strs[]){
         if(strs ==null || strs.length==0){
                     return "";
         }
         return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int s, int e) {
        if(s==e ){
                  return strs[s];
        }else{
            int mid =(s+e)/2;
            String left = longestCommonPrefix(strs,s,mid);
            String right = longestCommonPrefix(strs,mid+1,e);
            return commonPrefix(left,right);
        }

    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
            return left.substring(0, min);
    }
    //////////////////////////// end 分治










    //////////////////////////start 二分查找

      public String  二分查找(String [] strs){
        if(strs==null || strs.length==0){
             return "";
        }
        int minLen = Integer.MAX_VALUE;
          for (String str : strs) {
               minLen = Math.min(minLen,str.length());
          }

          int start = 0;
          int end  = minLen;
          while(start<=end){
              int middle = (start + end) / 2;
              if(isCommonPrefix(strs,middle)){
                  start = middle+1;
              }else{
                  end = middle-1;
              }
          }
          return strs[0].substring(0, (start + end) / 2);
      }

    private boolean isCommonPrefix(String[] strs, int middle) {
        String s  =strs[0].substring(0,middle);
        for (String str : strs) {
            if(!str.startsWith(s)){
                 return false;
            }
        }
        return true;
    }


    //////////////////////////end   二分查找





}
