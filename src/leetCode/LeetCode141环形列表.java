package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author acer
 * @Date 2019/7/30 22:36
 */
public class LeetCode141环形列表 {
    //证明是否有环 添加到hashset中 可以证明是否曾经添加到了hashset中
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }


    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (fastNode != null && fastNode.next != null) {
            if (fastNode == slowNode) {
                return true;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return false;
    }

    /**
     * 链表中是否有环 用快慢节点来判断 如果有环 则快节点一定回追上慢节点
     *
     * @param head
     * @return
     */
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode firstNode = head.next;
        ListNode secondNode = head;
        while (firstNode != null && firstNode.next != null) {
            if (firstNode == secondNode) {
                return true;
            }
            firstNode = firstNode.next.next;
            secondNode = secondNode.next;
        }
        return false;
    }
}
