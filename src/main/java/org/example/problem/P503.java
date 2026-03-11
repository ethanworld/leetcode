package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/10 21:40
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.util.Arrays;
import java.util.Stack;

public class P503 {

    static class Pair {
        int val;
        int idx;
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(nums[0], 0));
        int[] res = new int[nums.length * 2];
        Arrays.fill(res, -1);

        int[] copy = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
            copy[nums.length + i] = nums[i];
        }
        nums = copy;

        // 核心理解：stack只记录当前未找到答案的数据
        for (int i = 1; i < nums.length; i++) {
            // 当遇到比栈顶大的数据，则尝试依次弹栈
            while (!stack.isEmpty() && nums[i] > stack.peek().val) {
                res[stack.peek().idx] = nums[i];
                stack.pop();
            }
            stack.push(new Pair(nums[i], i));
        }
        copy = new int[nums.length / 2];
        System.arraycopy(res, 0, copy, 0, res.length / 2);
        return copy;
    }

    public static void main(String[] args) {
        P503 p503 = new P503();
        int[] nums = p503.nextGreaterElements(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(nums));
    }
}
