package leetCode;

/**
 * @author acer
 * @Date 2019/7/2 18:14
 */

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class LeetCode21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode myHead = new ListNode(-1);
        ListNode previous = myHead;
        while (l1 != null || l2 != null) {
            ListNode temp = null;
            if (l1 == null) {
                previous.next = l2;
                l2 = l2.next;
                previous = previous.next;
            } else if (l2 == null) {
                previous.next = l1;
                l1 = l1.next;
                previous = previous.next;
            } else {
                if (l1.val <= l2.val) {
                    previous.next = l1;
                    l1 = l1.next;
                    previous = previous.next;
                } else {
                    previous.next = l2;
                    l2 = l2.next;
                    previous = previous.next;
                }
            }
        }
        return myHead.next;
    }
}
