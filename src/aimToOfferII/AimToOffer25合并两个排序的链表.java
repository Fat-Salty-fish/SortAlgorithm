package aimToOfferII;

import leetCode.ListNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/30
 */
public class AimToOffer25合并两个排序的链表 {

    /**
     * 合并两个排序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            } else if (l2 == null) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    temp.next = l1;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    l2 = l2.next;
                }
                temp = temp.next;
            }
        }
        return result.next;
    }
}
