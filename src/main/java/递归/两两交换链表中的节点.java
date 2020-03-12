/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

package 递归;

import 链表.ListNode;

/**
 * 两两交换链表中的节点
 * 
 * @author x00418543
 * @since 2020年1月14日
 */
public class 两两交换链表中的节点 {

    public static void main(String[] args) {
        两两交换链表中的节点 l = new 两两交换链表中的节点();
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        head.next = l1;
        ListNode l2 = new ListNode(3);
        l1.next = l2;
        ListNode l3 = new ListNode(4);
        l2.next = l3;
        ListNode r = l.swapPairs2(head);
        System.out.println(r);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        // 递归
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

}
