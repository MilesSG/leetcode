package com.company.leetcode;

/**
 * title:
 *
 * @author: Miles
 * @date: 2022/9/26
 */
public class Test2 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(2);
        headA.next = new ListNode(4);
        headA.next.next = new ListNode(3);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(headA, headB);
        ListNode cur = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode headA = l1;
        ListNode headB = l2;
        // count为进位 如果有进位，则count变成1，没有进位则count变成0
        int count = 0;
        while (headA != null && headB != null) {
            int sum = headA.val + headB.val + count;
            if (sum >= 10) {
                sum -= 10;
                count = 1;
            } else {
                count = 0;
            }
            ListNode tmp = new ListNode(sum);
            pre.next = tmp;
            pre = pre.next;
            headA = headA.next;
            headB = headB.next;
        }

        // 下面考虑单个链表提前结束的情况
        /*
        1. 第二行链表提前结束，
        类似于：
        2 - 3 - 7 - 9 - 9 - 9
        1 - 2 - 5
        */
        while (headA != null) {
            int sum = headA.val + count;
            if (sum >= 10) {
                sum -= 10;
                count = 1;
            } else {
                count = 0;
            }
            ListNode tmp = new ListNode(sum);
            pre.next = tmp;
            pre = pre.next;
            headA = headA.next;
        }

        /*
        2. 第一行链表提前结束，
        类似于：
        1 - 2 - 5
        2 - 3 - 7 - 9 - 9 - 9
        */
        while (headB != null) {
            int sum = headB.val + count;
            if (sum >= 10) {
                sum -= 10;
                count = 1;
            } else {
                count = 0;
            }
            ListNode tmp = new ListNode(sum);
            pre.next = tmp;
            pre = pre.next;
            headB = headB.next;
        }

        // 还差最后一步：防止一直进1位的情况 比如 9 9 9 加到最后要进一位
        if (count == 1) {
            pre.next = new ListNode(1);
        }

        return dummy.next;
    }
}

