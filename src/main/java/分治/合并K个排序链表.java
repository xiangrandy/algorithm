/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */
package 分治;

import 链表.ListNode;

/**
 * 合并K个排序链表
 * 
 * @author x00418543
 * @since 2020年1月14日
 */
public class 合并K个排序链表 {

    public static void main(String[] args) {
        合并K个排序链表 h = new 合并K个排序链表();
        ListNode[] lists = { new ListNode(1), new ListNode(1), new ListNode(2) };
        ListNode node = h.mergeKLists(lists);
        System.out.println(node);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int left = 0;
        int right = lists.length - 1;
        // 分治
        while (right > 0) {
            while (left < right) {
                // 两两合并
                lists[left] = mergeTwoLists(lists[left], lists[right]);
                left++;
                right--;
            }
            left = 0;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
                pre = pre.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
                pre = pre.next;
            }
        }
        pre.next = l1 == null ? l2 : l1;
        return head.next;
    }

}
