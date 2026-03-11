package org.example.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/7 21:02
 * @Version: 1.0
 * @Desc :
 */
class P17 {

    static char[][] table = {{}, {},
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public void dfs(int pos, String digits, StringBuilder path, List<String> result) {

        if (path.length() == digits.length()) {
            System.out.println(path);
            result.add(path.toString());
            return;
        }
        for (Character c : table[digits.charAt(pos) - '0']) {
            path.append(c);
            dfs(pos + 1, digits, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(0, digits, path, result);
        return result;
    }

    public static void main(String[] args) {
        P17 p17 = new P17();
        p17.letterCombinations("23");

    }
}