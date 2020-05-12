package 算法;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: fang
 * @Date: 2020/4/23 22:25
 * @Description:
 */
public class java013罗马数字转整数 {

    public static void main(String[] args) {

      new java013罗马数字转整数().romanToInt("");

    }


    /**归纳总结几种特殊情况，如果含有 IV  IX  这种类型的特殊值。就做特殊操作
     * 换句话说，试探性读取两个字符，是否是特殊值，是的话就特殊处理，然后指针+2
     * 不是的话就正常处理 指针 +1
     *
     * @param s
     * @return
     */
    public int 试探比较两位字符(String s ){
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int result =0;
        for(int i =0;i<s.length();){

            if(i + 1 < s.length()  && map.containsKey(s.substring(i,i+2))){
                  result =result+map.get(s.substring(i,i+2));
                  i = i+2;
            }else{
                result =result+map.get(s.substring(i,i+1));
                i = i+1;
            }

        }
         return result;
    }


    /**仔细观察，特例只是 4   9   40  90  等这种 类型的特例，也就是说这种情况下这种类型的符号，左边会比右边小
     *
     * 换句话说，遍历字符的同时，记录下当前的大小，  用于和下一个字符比较大小。
     * 如果左边的比右边的小，那么就需要把总数减下来。
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character ,Integer> map=new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result=0;
        int lastPointValue=0;
        for (char c : s.toCharArray()) {
            Integer curr = map.get(c);
            if(lastPointValue<curr){
                // 因为之前对这个特殊情况的字符做过加操作，结果这个字符不仅不加，还要减 所以这里减*2
                result=result-lastPointValue*2;
            }
            lastPointValue = curr;
            result=result+curr;

        }
        return result;
    }

}
