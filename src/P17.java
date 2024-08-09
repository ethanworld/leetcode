package src;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：17. 电话号码的字母组合
 * 算法：回溯法，dfs
 */
public class P17 {
    char[][] map = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    String pathToStr(ArrayList<Character> path) {
        StringBuilder buffer = new StringBuilder();
        for (char ch : path) {
            buffer.append(ch);
        }
        return buffer.toString();
    }

    void dfs(ArrayList<String> results, ArrayList<Character> path, int pointer, String digits) {
        if (pointer == digits.length()) {
            results.add(pathToStr(path));
            return;
        }
        for (char ch : map[digits.charAt(pointer) - '0']) {
            path.add(ch);
            dfs(results, path, pointer + 1, digits);
            path.remove(path.size() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> results = new ArrayList<>();
        if (digits.length() == 0) {
            return results;
        }
        ArrayList<Character> path = new ArrayList<>();
        dfs(results, path, 0, digits);
        return results;
    }

    public static void main(String[] args) {
        P17 p17 = new P17();
        List<String> rst = p17.letterCombinations("");
        for (String str : rst) {
            System.out.println(str);
        }
    }
}
