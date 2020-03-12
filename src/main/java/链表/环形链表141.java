package 链表;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 双指针解决
 * 
 * @author x00418543
 * @since 2020年2月10日
 */
public class 环形链表141 {

    public static void main(String[] args) {
        环形链表141 h = new 环形链表141();
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> seenNodes = new HashSet<>();
        while (head != null) {
            if (seenNodes.contains(head)) {
                return true;
            } else {
                seenNodes.add(head);
            }
            head = head.next;
        }
        return false;
    }

}
