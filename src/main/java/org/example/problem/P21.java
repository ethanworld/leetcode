package org.example.problem;

import org.example.util.ListNode;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/7 22:21
 * @Version: 1.0
 * @Desc :
 */
public class P21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {return list2;}
        if (list2 == null) {return list1;}

        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = new ListNode(0);

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                head.next = p1;
                p1 = p1.next;
            } else {
                head.next = p2;
                p2 = p2.next;
            }
            head = head.next;
        }

        // 继承剩余的链表
        if (p1 != null) {
            head.next = p1;
        }
        if (p2 != null) {
            head.next = p2;
        }
        return list1.val <= list2.val ? list1 : list2;
    }
}
