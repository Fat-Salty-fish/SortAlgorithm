package leetCode;

/**
 * @Author lizhongjie
 * @Date 2019/12/24
 * @Desc
 **/
public class LeetCode24两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        ListNode result = dummyNode;
        dummyNode.next = head;
        swap(dummyNode);
        return result.next;
    }

    public void swap(ListNode dummyNode) {
        if (dummyNode == null) {
            return;
        }
        ListNode node1 = dummyNode.next;
        if (node1 == null) {
            return;
        }
        ListNode node2 = node1.next;
        if(node2 == null){
            return;
        }
        dummyNode.next = node2;
        node1.next = node2.next;
        node2.next = node1;
        dummyNode = dummyNode.next.next;
        swap(dummyNode);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
        ListNode temp = new LeetCode24两两交换链表中的节点().swapPairs(null);
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
