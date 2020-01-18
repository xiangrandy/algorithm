package 链表;

import java.util.ArrayList;
import java.util.List;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月14日
 */
public class 合并两个有序链表 {

    public static void main(String[] args) {
        合并两个有序链表 h = new 合并两个有序链表();
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;
        ListNode merged = h.mergeTwoLists(l1, l2);
        System.out.println(merged);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        List<ListNode> l = new ArrayList<>();
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l.add(l2);
                l2 = l2.next;
            } else if (l2 == null) {
                l.add(l1);
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                // 加入node
                l.add(l1);
                l1 = l1.next;
            } else {
                // 加入node
                l.add(l2);
                l2 = l2.next;
            }
        }
        for (int i = l.size() - 1; i >= 1; i--) {
            l.get(i - 1).next = l.get(i);
        }
        return l.get(0);
    }

}
