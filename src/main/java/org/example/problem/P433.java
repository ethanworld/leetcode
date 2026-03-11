package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/10 10:03
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P433 {

    static class Pair {
        String bk;
        int level;
        Pair(String bk, int level) {
            this.bk = bk;
            this.level = level;
        }
    }

    boolean check(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startGene, 0));
        boolean[] visited = new boolean[bank.length];

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < bank.length; i++) {
                if (visited[i] || !check(pair.bk, bank[i])) {
                    continue;
                }
                if (bank[i].equals(endGene)) {
                    return pair.level + 1;
                }
                // visited不用回溯，因为如果当前能被访问而不能匹配，那么后面也无需访问了
                visited[i] = true;
                queue.add(new Pair(bank[i], pair.level + 1));
            }
        }


        return -1;
    }


    public static void main(String[] args) {
        P433 p = new P433();
        System.out.println(p.minMutation("AACCTTGG", "AATTCCGG", new String[]{"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"}));
    }

}
