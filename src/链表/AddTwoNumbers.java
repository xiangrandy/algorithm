package 链表;

import java.util.ArrayList;
import java.util.List;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 两数相加
 * 
 * @author x00418543
 * @since 2020年1月11日
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode node = a.addTwoNumbers(l1, l2);
        System.out.println(node);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead, next1 = l1, next2 = l2;
        int jinwei = 0;
        while (next1 != null || next2 != null || jinwei > 0) {
            int r = (next1 == null ? 0 : next1.val) + (next2 == null ? 0 : next2.val) + jinwei;
            jinwei = r / 10;
            current.next = new ListNode(r % 10);
            current = current.next;
            next1 = next1 == null ? null : next1.next;
            next2 = next2 == null ? null : next2.next;
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        List<ListNode> l = new ArrayList<>();
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        int jinwei = (l1.val + l2.val) / 10;
        l.add(result);
        ListNode next1 = l1.next;
        ListNode next2 = l2.next;
        while (next1 != null || next2 != null || jinwei > 0) {
            int r = (next1 == null ? 0 : next1.val) + (next2 == null ? 0 : next2.val) + jinwei;
            ListNode node = new ListNode((r) % 10);
            l.add(node);
            jinwei = r / 10;
            next1 = next1 == null ? null : next1.next;
            next2 = next2 == null ? null : next2.next;
        }
        for (int i = l.size() - 1; i >= 1; i--) {
            l.get(i - 1).next = l.get(i);
        }
        return l.get(0);
    }

}
