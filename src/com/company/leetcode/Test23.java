package com.company.leetcode;

import java.util.List;

/**
 * title: 23. 合并K个升序链表
 *
 * @author: Miles
 * @date: 2022/10/10
 */
public class Test23 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;

        ListNode[] lists = {node1, node4, node7};
        ListNode res = new Test23().mergeKLists(lists);

        ListNode tmp = res;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode cur = null;
        for (ListNode node : lists) {
            cur = merge(cur, node);
        }
        return cur;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return (list1 == null) ? list2 : list1;
        }
        if (list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list2.next, list1);
            return list2;
        }
    }
}
