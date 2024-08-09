package src;

import util.UnitTest;

import java.util.Stack;

/**
 *
 * 题目：20. 有效的括号
 * 算法：栈
 */
public class P20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.size() > 0 && stack.peek() == '('){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.size() > 0 && stack.peek() == '['){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.size() > 0 && stack.peek() == '{'){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        P20 p20 = new P20();
        UnitTest.EXPERT_EQ(p20.isValid("()[]{}"), true);
        UnitTest.EXPERT_EQ(p20.isValid("(]"), false);
        UnitTest.EXPERT_EQ(p20.isValid("]"), false);
    }
}
