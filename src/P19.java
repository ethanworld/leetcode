package src;

import util.ListNode;

/**
 * 题目：19. 删除链表的倒数第 N 个结点
 * 算法：双指针，快慢指针
 */

public class P19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 前后双指针
        ListNode p1 = head, p2= head;
        for (int idx = 0; idx < n; idx++) {
            p2 = p2.next;
        }

        if (p2 == null) {
            if (head.next == null) {
                return null;
            } else {
                return head.next;
            }
        }
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}
