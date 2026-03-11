package org.example.problem;

import org.example.util.ListNode;

/**
 * @author : ethan
 * @date : 2026/3/8 18:35
 * @Version: 1.0
 * @Desc :
 */
public class P142 {


    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // step1: 判定是否有环
        ListNode slow = head, fast = head.next;
        int cnt = 0;
        boolean flag = false;
        while (slow != null && fast != null) {
            if (slow == fast) {
                flag = true;
                break;
            }
            fast = fast.next;
            if (cnt % 2 == 0) {
                slow = slow.next;
            }
            cnt++;
        }
        if (!flag) {
            return null;
        }

        // step2: 慢指针走一圈，计算环长度
        ListNode tmp = slow.next;
        int loop_cnt = 1;
        while (tmp != slow) {
            tmp = tmp.next;
            loop_cnt++;
        }

        // step3: 双指针，后者先走loop_cnt，再一起走，相遇时为环入口
        // 总长度 n = a + b, a 为前面不重复的长度， b为环形长度。两个指针其中一个先走b，然后两个指针再同时走，当一起走了a+b距离时，先走的那个指针一共走了a+b+b，两指针相遇。此时为圆的起点
        ListNode left = head, right = head;
        while (loop_cnt-- > 0) {
            right = right.next;
        }
        while (left != right) {
            left = left.next;
            right = right.next;
        }
        return left;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        P142 p142 = new P142();
        p142.detectCycle(n1);
    }

}
