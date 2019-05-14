package com.company.validparentheses_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private static Map<Character, Character> mappings;

    public ValidParentheses() {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    private static boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //如果当前字符是结束括号
            if (mappings.containsKey(c)) {

                //获取栈顶元素（如果堆栈为空，请设置虚拟值“＃”）
                char topElement = characterStack.empty() ? '#' : characterStack.pop();

                //如果此括号的映射与堆栈的top元素不匹配，则返回false
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                //如果它是一个开始括号，推到堆中
                characterStack.push(c);
            }

        }
        return characterStack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
