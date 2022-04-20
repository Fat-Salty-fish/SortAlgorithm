package aimToOfferII;

import leetCode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/30
 */
public class AimToOffer24反转链表 {

    /**
     * 不知道做过多少次了
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null){
            deque.push(head);
            head = head.next;
        }
        ListNode result = null;
        ListNode pre = null;
        while (!deque.isEmpty()){
            ListNode temp = deque.poll();
            if (result == null){
                result = temp;
                pre = temp;
            }else {
                pre.next = temp;
                pre = temp;
            }
            temp.next = null;
        }
        return result;
    }

    /**
     * 直接一个迭代
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        ListNode pre = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
