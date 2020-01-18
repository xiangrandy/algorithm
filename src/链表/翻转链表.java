/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

package 链表;

/**
 * 链表翻转
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class 翻转链表 {

    public static void main(String[] args) {
        翻转链表 f = new 翻转链表();
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode t1 = new ListNode(6);
        ListNode t2 = new ListNode(7);
        t1.next = t2;
        ListNode reversed = f.reverseAndConnect(head, t1);
        System.out.println(reversed);
    }

    public ListNode reverse(ListNode header) {
        if (header == null || header.next == null) {
            return header;
        }
        ListNode pre = header, cur = header.next;
        pre.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseAndConnect(ListNode header, ListNode nextToConnect) {
        if (header == null || header.next == null) {
            return header;
        }
        ListNode pre = header, cur = header.next;
        pre.next = nextToConnect;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
