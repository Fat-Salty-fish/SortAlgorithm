package aimToOffer.reverseList;

/**
 * @author acer
 * @Date 2019/4/10 17:19
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode ReverseList(ListNode head) {
//        ListNode tail = new ListNode(head.val);
        //这个节点是用来最后返回的头节点
        ListNode myHead = new ListNode(0);
        if (head == null) {
            return null;
        } else if (head.next == null) {
            myHead.val = head.val;
            return myHead;
        } else {
            while (head != null) {
                //获取当前结点的值 并赋予一个新的值
                ListNode node = new ListNode(head.val);
                node.next = myHead.next;
                myHead.next = node;
                if(head.next==null)
                    break;
                head = head.next;
            }
            return myHead.next;
        }
    }
}
