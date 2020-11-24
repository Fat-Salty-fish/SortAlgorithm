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
        if (node2 == null) {
            return;
        }
        dummyNode.next = node2;
        node1.next = node2.next;
        node2.next = node1;
        dummyNode = dummyNode.next.next;
        swap(dummyNode);
    }

    /**
     * 每次翻转之后的头节点 需要保留
     */
    ListNode headNode;

    /**
     * 尾节点
     */
    ListNode tailNode;

    /**
     * 是否需要翻转
     * 默认需要翻转
     */
    Boolean needToSwap = Boolean.TRUE;

    /**
     * 交换两个节点 其实和每k个节点交换一次 是一样的
     * 只不过是这个k是2
     * 所以完全可以用每k个节点交换一次来解决
     * 用每k个节点交换一次来尝试解决一下
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 每2个节点反转一次
        return reverseForEveryK(head, 2);
    }

    /**
     * 每k个节点反转一次
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseForEveryK(ListNode head, Integer k) {
        if (head == null || head.next == null || k <= 1){
            return head;
        }
        ListNode result = reverseK(head,2);
        while (needToSwap) {
            headNode.next = reverseK(headNode.next, 2);
        }
        return result;
    }


    /**
     * 当k为1时 表示当前节点为最后需要翻转的链的最后一个节点 不需要翻转
     * 并且当前节点也会是翻转的链的头节点 所以直接返回当前节点
     * 并且 当前节点的next节点为翻转链表之后 尾节点的第一个节点 在之后翻转节点之后都应该指向这个节点
     * 所以需要保存一下这个节点 即tailNode = head.next
     *
     * 当k不为1时 先翻转head.next个节点 并获取翻转链表之后的头节点
     * head.next.next需要指向head(head与head.next翻转关系)
     * head.next需要指向tailNode(当前节点需要作为翻转链的最后一个节点)
     * 最后依然返回头节点即可
     *
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseK(ListNode head, Integer k) {
        if (head == null && k > 0) {
            needToSwap = Boolean.FALSE;
            return null;
        }
        if (head != null && k == 1) {
            tailNode = head.next;
            return head;
        }
        ListNode result = reverseK(head.next, k - 1);
        if (needToSwap) {
            head.next.next = head;
            head.next = tailNode;
            // 这里需要记录一下旋转链的尾节点
            headNode = head;
            return result;
        } else {
            return head;
        }
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
        ListNode temp = new LeetCode24两两交换链表中的节点().swapPairs2(node1);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
