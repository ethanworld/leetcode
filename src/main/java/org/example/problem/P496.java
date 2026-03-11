package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/10 21:40
 * @Version: 1.0
 * @Desc :
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class P496 {

    static class Pair {
        int val;
        int idx;
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(nums2[0], 0));
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            map.put(j, -1);
        }

        // 核心理解：stack只记录当前未找到答案的数据
        for (int i = 1; i < nums2.length; i++) {
            // 当遇到比栈顶大的数据，则尝试依次弹栈
            while (!stack.isEmpty() && nums2[i] > stack.peek().val) {
                if (map.containsKey(stack.peek().val)) {
                    map.put(stack.peek().val, nums2[i]);
                }
                stack.pop();
            }
            stack.push(new Pair(nums2[i], i));
        }

        int[] ans = new int[nums1.length];
        for (int i = nums1.length - 1; i >= 0; i--) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
