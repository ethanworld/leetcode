package org.example.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 11:21
 * @Version: 1.0
 * @Desc :
 */
public class P93 {
    private String s;

    boolean checkValid(ArrayList<Integer> path) {
        int cnt = 0;
        for (Integer i : path) {
            if (cnt + i > s.length() || Integer.parseInt(s.substring(cnt, cnt + i)) > 255) {
                return false;
            }
            // 不允许0开头
            if (i > 1 && s.substring(cnt, cnt + i).startsWith("0") ) {
                return false;
            }
            cnt += i;
        }
        return cnt == s.length();
    }

    void dfs(ArrayList<Integer> path, List<String> result) {

        if (path.size() == 4) {
            if (!checkValid(path)) {
                return;
            }
            StringBuilder builder = new StringBuilder();
            int cnt = 0;
            for (Integer i : path) {
                builder.append(s, cnt, cnt + i);
                builder.append(".");
                cnt += i;
            }
            builder.deleteCharAt(builder.length() - 1);
            result.add(builder.toString());
            return;
        }

        // 每个数字至少1位，至多3位
        for (int i = 1; i <=3; i++) {
            path.add(i);
            dfs(path, result);
            path.removeLast();
        }
    }

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        List<String> result = new ArrayList<>();
        dfs(new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        P93 p93 = new P93();
        p93.restoreIpAddresses("25525511135");
    }

}
