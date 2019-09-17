package leetCode;

/**
 * @author acer
 * @Date 2019/5/2 16:27
 */

public class LeetCode203 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode myHead = new ListNode(-1);
        myHead.next = head;
        ListNode current = myHead;
        //如果当前节点不为空
        while (current.next!=null) {
            //如果下一个节点的val值和给定的val值相同
            if(current.next.val == val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return myHead.next;
    }
}
