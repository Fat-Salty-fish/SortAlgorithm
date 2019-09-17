package leetCode;

import sortFunctions.HeapSort;

/**
 * @author acer
 * @Date 2019/8/10 19:00
 */
public class LeetCode61 {
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

}
