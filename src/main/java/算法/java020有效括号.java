package 算法;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: fang
 * @Date: 2020/4/20 22:03
 * @Description:
 */
public class java020有效括号 {

    public static void main(String[] args) {

        String s = "()[]{}";

        System.out.println(valid(s));


    }


    private static boolean valid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
                continue;
            }
            Character pop = stack.pop();  //比较栈顶和不是 }]) 是否相等
            if (!map.get(c).equals(pop)) {
                return false;
            }
        }
        return stack.empty();
    }

    public boolean replace取巧(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return "".equals(s);
    }

}
