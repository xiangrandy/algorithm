package 链表;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月14日
 */
public class 删除链表的倒数第N个节点 {

    public static void main(String[] args) {
        删除链表的倒数第N个节点 s = new 删除链表的倒数第N个节点();
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        head.next = l2;
        l2.next = l3;
        int n = 2;
        ListNode node = s.removeNthFromEnd(head, n);
        System.out.println(node);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode removeItsNext = head;
        ListNode current = head.next;
        int i = 2;// removeItsNext在倒数第二位
        boolean found = false;
        if (n == 1) {
            found = true;
        }
        while (current.next != null) {
            // current指向下一位
            current = current.next;
            // removeItsNext变成倒数第i+1位
            i++;
            if (i == n + 1) {
                // 如果i == n+1，找到了
                found = true;
            }
            if (i == n + 2) {
                // 如果removeItsNext变成倒数第n+2位
                removeItsNext = removeItsNext.next;
                i--;
            }
        }
        if (found) {
            removeItsNext.next = removeItsNext.next.next;
            return head;
        } else {
            return head.next;
        }
    }

}
