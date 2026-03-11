package org.example.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : ethan
 * @date : 2026/3/9 8:02
 * @Version: 1.0
 * @Desc :
 */
public class P210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            // 图记录哪些被自己依赖
            graph.get(prerequisite[1]).add(prerequisite[0]);
            // 数组记录入度
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // 所有入度为0加入队列
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            // 从队首取出
            int course = queue.poll();
            res[idx] = 0;
            idx++;

            // 处理对应被依赖课程
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        if (idx != numCourses) {
            return new int[0];
        }
        return res;
    }

}
