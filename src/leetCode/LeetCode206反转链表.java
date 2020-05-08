package leetCode;


import java.util.List;

public class LeetCode206反转链表 {
    /**
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * @param head
     * @return
     */
    //迭代方法实现
    public ListNode solution(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode temp = null;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    //递归方法实现
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    //迭代方法实现2
    public ListNode reverseList2(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        while (head != null) {
            ListNode left = dummyNode.next;
            ListNode next = head.next;
            dummyNode.next = head;
            dummyNode.next.next = left;
            head = next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = new LeetCode206反转链表().reverseList2(node1);
        System.out.println(result.val);
    }
}
