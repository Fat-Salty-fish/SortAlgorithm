package aimToOfferII;

import leetCode.ListNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/30
 */
public class AimToOffer22链表中倒数第K个节点 {


    /**
     * 倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        while (fast.next != null && k != 1) {
            fast = fast.next;
            k--;
        }
        if (k != 1) {
            return null;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
