package leetCode;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针

/**
 * @Author lizhongjie
 * @Date 2019/12/23
 * @Desc
 **/
public class LeetCode19删除链表的第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode node1 = dummy;
        ListNode node2 = dummy;
        dummy.next = head;
        for (int i = 1; i <= n+1; i++) {
            node1 = node1.next;
        }
        while (node1 != null){
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next = node2.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;

        System.out.println(new LeetCode19删除链表的第N个节点().removeNthFromEnd(node1, 2));
    }
}
