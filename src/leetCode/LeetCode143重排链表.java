package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/31
 */
public class LeetCode143重排链表 {


    /**
     * 曾经在头条面试时的题目
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode firstNode = head;
        ListNode secondNode = head;
        while (secondNode != null && secondNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next.next;
        }
        // 后面链表的头节点
        secondNode = reverseNode(firstNode.next);
        firstNode.next = null;
        combineTwoList(head,secondNode);

    }

    public ListNode reverseNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode result = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    /**
     * 合并两个链表
     * 交叉合并
     *
     * @param firstHead
     * @param secondHead
     * @return
     */
    public ListNode combineTwoList(ListNode firstHead, ListNode secondHead) {
        ListNode dummyNode = new ListNode(-1);
        ListNode tempNode = dummyNode;
        while (firstHead != null || secondHead != null) {
            if (firstHead!=null){
                tempNode.next = firstHead;
                firstHead = firstHead.next;
                tempNode = tempNode.next;
            }
            if (secondHead!=null){
                tempNode.next = secondHead;
                secondHead = secondHead.next;
                tempNode = tempNode.next;
            }
        }
        return dummyNode.next;
    }

}
