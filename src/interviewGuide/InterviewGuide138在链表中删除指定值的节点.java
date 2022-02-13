package interviewGuide;

import leetCode.ListNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/7
 */
public class InterviewGuide138在链表中删除指定值的节点 {

    /**
     * 从链表中删除值为k的节点
     *
     * @param node
     * @param k
     * @return
     */
    public ListNode removeNodeWithValue(ListNode node, int k) {
        ListNode pre = null;
        ListNode current = node;
        ListNode result = null;
        while (current != null) {
            ListNode next = current.next;
            // 不需要删除
            if (current.val != k) {
                if (result == null) {
                    result = current;
                }
                pre = current;
            } else {
                if (pre != null) {
                    pre.next = next;
                }
            }
            current = next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(13);
        ListNode node3 = new ListNode(11);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(13);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode result = new InterviewGuide138在链表中删除指定值的节点().removeNodeWithValue(node1, 13);
        System.out.println(result.val);
    }
}
