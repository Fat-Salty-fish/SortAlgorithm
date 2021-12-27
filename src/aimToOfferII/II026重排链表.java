package aimToOfferII;

import leetCode.ListNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/3
 */
public class II026重排链表 {

    /**
     * 重排链表
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;

        ListNode reversedList = reverse(secondHead);
        ListNode combined = combineList(head, reversedList);
    }


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode combineList(ListNode firstHead, ListNode secondHead) {
        ListNode dummyNode = new ListNode(0);
        ListNode tempLeft = firstHead;
        ListNode tempRight = secondHead;
        ListNode result = dummyNode;
        while (tempLeft != null || tempRight != null) {
            if (tempLeft != null) {
                ListNode temp = dummyNode.next;
                dummyNode.next = tempLeft;
                dummyNode = dummyNode.next;
                tempLeft = tempLeft.next;
            }
            if (tempRight != null) {
                dummyNode.next = tempRight;
                dummyNode = dummyNode.next;
                tempRight = tempRight.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
//        ListNode head = new II026重排链表().reverse(first);
//        System.out.println(head.val);
        new II026重排链表().reorderList(first);
        System.out.println("成功了");
    }
}
