package leetCode;

/**
 * @author acer
 * @Date 2019/8/12 10:31
 */
public class LeetCode148 {
    //归并排序 自顶向下
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //使用快慢指针寻找中点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        //断链
        slow.next = null;
        //递归调用 左子链
        ListNode left = sortList(head);
        //递归调用 右子链
        ListNode right = sortList(temp);

        //进行合并 使用h作为一个临时节点
        ListNode h = new ListNode(0);
        ListNode res = h;

        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;

        return res.next;
    }

    //归并排序 自底向上
    public ListNode sortList2(ListNode head) {
        return null;
    }
}
