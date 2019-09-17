package leetCode;

/**
 * @author acer
 * @Date 2019/5/2 16:21
 */


/**
 * 删除链表中的某个节点 给定一个链表以及
 */
public class LeetCode237 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        if(node==null){
            return ;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}