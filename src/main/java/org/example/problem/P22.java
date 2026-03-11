package org.example.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 8:25
 * @Version: 1.0
 * @Desc :
 */
public class P22 {

    static char[] table = {'(', ')'};

    boolean checkValid(int left, int right, int n)
    {
        if (left == 0 && right == 0) {
            return true;
        }
        if (left < right) {
            return false;
        }
        return left <= n;
    }

    private void dfs(int n, List<String> result, StringBuilder path, int left, int right) {

        // 每次都小步校验合法性，就能保证全局合法性
        if (!checkValid(left, right, n)) {
            return;
        }

        if (path.length() == n * 2) {
            System.out.println(path.toString());
            result.add(path.toString());
            return;
        }

        for (Character c : table) {
            path.append(c);
            dfs(n , result, path, c == '(' ? left + 1 : left, c == ')' ? right + 1 : right);
            path.deleteCharAt(path.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        dfs(n ,  result, new StringBuilder(), 0, 0);
        return result;
    }

    public static void main(String[] args) {
        P22 p22 = new P22();
        p22.generateParenthesis(3);
    }
}
