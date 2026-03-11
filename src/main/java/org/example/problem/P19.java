package org.example.problem;

import org.example.util.ListNode;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/7 21:43
 * @Version: 1.0
 * @Desc :
 */
public class P19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode first = head, pos = head;
            for (int idx = 0; idx < n; idx++) {
                first = first.next;
            }
            if (first == null) {
                return pos != null ? pos.next : null;
            }
            while (first.next != null) {
                first = first.next;
                pos = pos.next;
            }
            if (pos != null && pos.next != null) {
                pos.next = pos.next.next;
            }
            return head;
        }
    }
}
