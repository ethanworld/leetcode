package org.example.problem;

import org.example.util.ListNode;

/**
 * @author : ethan
 * @date : 2026/3/8 18:35
 * @Version: 1.0
 * @Desc :
 */
public class P141 {


    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow = head, fast = head.next;
        int cnt = 0;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            fast = fast.next;
            if (cnt % 2 == 0) {
                slow = slow.next;
            }
            cnt++;
        }
        return false;
    }

}
