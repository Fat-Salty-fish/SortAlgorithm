package aimToOfferII;

import leetCode.ListNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/30
 */
public class AimToOffer18删除链表的节点 {

    /**
     * 删除链表节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = null;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == val) {
                if (pre != null) {
                    pre.next = temp.next;
                    break;
                }
            }
            pre = temp;
            temp = temp.next;
        }
        return head;
    }
}
