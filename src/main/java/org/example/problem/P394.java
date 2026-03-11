package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/9 17:51
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P394 {

    public String dfs(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        // case1: 字符串开头
        if (!s.isEmpty() && Character.isLetter(s.charAt(i))) {
            for (; i < s.length() && Character.isLetter(s.charAt(i)); i++) {
                sb.append(s.charAt(i));
            }
        }

        // case2: 数字开头
        if (!s.isEmpty() && Character.isDigit(s.charAt(i))) {
            int num = 0;
            for (; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
                num = num * 10 + s.charAt(i) - '0';
            }
            // 略过左中括号：[
            i++;
            String ret = dfs(s.substring(i));
            while(num-- > 0 && ret != null) {
                sb.append(ret);
            }
            // 略过右中括号：]
            i++;
        }
        return sb.toString() + dfs(s.substring(i));
    }

    public String decodeString(String s) {
        String ret = dfs(s);
        return ret;
    }

    public static void main(String[] args) {
        P394 p394 = new P394();
//        System.out.println(p394.dfs("3[a2[c]]"));
        System.out.println(p394.dfs("3[a]2[bc]"));
    }
}

