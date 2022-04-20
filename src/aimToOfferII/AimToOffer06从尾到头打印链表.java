package aimToOfferII;

import leetCode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/26
 */
public class AimToOffer06从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head!=null){
            deque.push(head);
            head = head.next;
        }
        int[] result = new int[deque.size()];
        int index = 0;
        while (!deque.isEmpty()){
            result[index++] = deque.pop().val;
        }
        return result;
    }
}
