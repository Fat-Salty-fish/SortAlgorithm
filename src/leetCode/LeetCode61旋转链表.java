package leetCode;

import sortFunctions.HeapSort;

/**
 * @author acer
 * @Date 2019/8/10 19:00
 */
public class LeetCode61旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        if (head == null) {
            return null;
        }
        ListNode myHead = head;
        ListNode current = head;
        int size = 0;
        ListNode lastNode = null;
        //第一步 获取最后一个节点并获取整个链表的长度 并将最后一个节点的下一个节点指向头结点
        while (current != null) {
            size++;
            if (current.next == null) {
                lastNode = current;
            }
            current = current.next;
        }
        lastNode.next = head;
        //第二步 计算移动之后的根节点是哪一个
        int step = k % size;
        //第三步 从现在根节点开始计算 之后的第(size - step)个节点的next指向空即可
        current = myHead;
        for (int i = 0; i < (size - step)-1; i++){
            current = current.next;
        }
        ListNode ans = current.next;
        current.next = null;
            return ans;
    }


    public ListNode lastNode;

    /**
     * 旋转链表 将链表每个节点向右移动k个节点
     * 微软模拟面试
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null){
            return head;
        }
        ListNode myHead = head;
        int listSize = getListSizeAndGetLastNode(head);
        int mod = k % listSize;
        // 旋转size个节点 等于不旋转
        if (mod == 0) {
            return head;
        }
        lastNode.next = myHead;
        // 获取末尾节点
        int lastNode = listSize - mod - 1;
        ListNode result = myHead;
        for (int i = 0; i < lastNode; i++) {
            myHead = myHead.next;
        }
        result = myHead.next;
        myHead.next = null;
        return result;
    }

    /**
     * 获取链表长度
     *
     * @param head 链表头节点
     * @return
     */
    public int getListSizeAndGetLastNode(ListNode head) {
        if (head == null) {
            return 0;
        }
        int result = 0;
        while (head != null) {
            lastNode = head;
            result++;
            head = head.next;
        }
        return result;
    }

}
