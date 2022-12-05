package com.company.leetcode;

/**
 * title: 25. K 个一组翻转链表
 *
 * @author: Miles
 * @date: 2022/10/10
 */
public class Test25 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = new Test25().reverseKGroup(node1, 2);
        ListNode cur = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode firstHead = head;
        ListNode firstTail = head;
        ListNode secondHead = head;
        for (int i = 0; i < k - 1; i++) {
            firstTail = firstTail.next;
            if (firstTail == null) return head;
        }
        secondHead = firstTail.next;
        firstTail.next = null;
        reverse(firstHead);
        firstHead.next = reverseKGroup(secondHead, k);
        return firstTail;
    }

    private void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
    }
}
