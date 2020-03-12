/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

package 链表;

/**
 * 链表翻转
 * 
 * @author x00418543
 * @since 2020年1月14日
 */
public class K个一组翻转链表 {

    public static void main(String[] args) {
        K个一组翻转链表 f = new K个一组翻转链表();
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        int k = 2;
        ListNode n = f.reverseKGroup(head, k);
        System.out.println(n);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        ListNode first = null;
        ListNode kth = null;
        while (((first = temp.next) != null) && (kth = findKth(first, k)) != null) {
            ListNode rest = kth.next;
            // 逆序改节点
            kth.next = null;
            ListNode reversed = reverseAndConnect(first, rest);
            // temp的节点改为K个中第一个节点
            temp.next = reversed;
            temp = first;
        }
        return pre.next;
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

    private ListNode findKth(ListNode temp, int k) {
        for (int i = 1; i < k; i++) {
            if (temp.next == null) {
                return null;
            }
            temp = temp.next;
        }
        return temp;
    }

}
