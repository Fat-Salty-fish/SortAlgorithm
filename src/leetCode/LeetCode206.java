package leetCode;


import java.util.List;

public class LeetCode206 {
    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * @param head
     * @return
     */
    //迭代方法实现
    public ListNode solution(ListNode head){
        ListNode previous = null;
        ListNode current = head;
        ListNode temp = null;
        while (current!=null){
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    //递归方法实现
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null )
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
