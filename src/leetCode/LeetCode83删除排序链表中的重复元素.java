package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/11/26
 */
public class LeetCode83删除排序链表中的重复元素 {
    /**
     * 因为已经排好顺序了 所以直接向后
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head;
        while (firstNode != null) {
            // 寻找下一个比当前节点大的节点
            while (secondNode != null && secondNode.val <= firstNode.val) {
                secondNode = secondNode.next;
            }
            firstNode.next = secondNode;
            firstNode = firstNode.next;
        }
        return head;
    }


}
