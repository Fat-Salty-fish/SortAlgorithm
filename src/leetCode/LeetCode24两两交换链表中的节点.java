package leetCode;

/**
 * @Author lizhongjie
 * @Date 2019/12/24
 * @Desc
 **/
public class LeetCode24两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        ListNode result = new ListNode(0);
        dummyNode.next = head;
        ListNode node1 = dummyNode.next;
        ListNode node2 = dummyNode.next.next;

        swap(dummyNode,node1,node2);
        dummyNode.next = dummyNode.next.next.next;
        result.next = dummyNode.next;
        node1 = dummyNode.next;
        node2 = dummyNode.next.next;
        while (node1 != null && node2 != null) {
            swap(dummyNode, node1, node2);
            dummyNode.next = dummyNode.next.next.next;
            node1 = dummyNode.next;
            node2 = dummyNode.next.next;
        }
        return result.next;
    }

    public void swap(ListNode dummyNode, ListNode node1, ListNode node2) {
        dummyNode.next = node2;
        node1.next = node2.next;
        node2.next = node1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;


    }
}
