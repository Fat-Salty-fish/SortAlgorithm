package aimToOffer.findKthToTail;

/**
 * @author acer
 * @Date 2019/4/10 17:14
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        int n = 0;
        for (; p != null; n++) {
            if (n >= k) {
                q = q.next;
            }
            p = p.next;
        }
        return n < k ? null : q;
    }
}
