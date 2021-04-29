package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/4/12
 */
public class LeetCode86分隔链表 {
    /**
     * 分隔链表 这不就是快速排序吗
     * 但是注意：这是个链表 不是数组
     * 无法向左遍历
     * 而且这个是链表 是不是必须交换节点？还是说交换值即可
     * 应该是要交换节点 必须会有双指针
     * 我他妈想太多了
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode smallNode = new ListNode(0);
        ListNode smallIndex = smallNode;
        ListNode bigNode = new ListNode(0);
        ListNode bigIndex = bigNode;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                smallIndex.next = temp;
                smallIndex = smallIndex.next;
            } else {
                bigIndex.next = temp;
                bigIndex = bigIndex.next;
            }
            temp = temp.next;
        }
        smallIndex.next = bigNode.next;
        bigIndex.next = null;
        return smallNode.next;
    }
}
