package leetCode;

import java.util.Stack;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/9/18
 */
public class LeetCode92反转链表2 {
    // 反转从m到n的链表
    // m从1开始计算(不送从0开始)
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        int current = 1;
        ListNode index = head;
        ListNode firstTail = head;
        while (current < m - 1 && index != null) {
            index = index.next;
            current++;
        }
        firstTail = index;
        ListNode secondHead = firstTail.next;
        ListNode secondTail = index;
        while (current < n && index != null) {
            index = index.next;
            current++;
        }
        secondTail = index;
        ListNode thirdHead = secondTail.next;

        // 三条链断开
        firstTail.next = null;
        secondTail.next = null;
        // 中间链反转
        ListNode nextHead = reverse(secondHead);
        // 再拼接
        firstTail.next = nextHead;
        secondHead.next = thirdHead;
        return head;
    }


    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return nextHead;
    }

    ListNode finallyNode = null;

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseFromHead(head, n);
        }
        head.next  =  reverseBetween2(head.next, m - 1, n - 1);
        return head;
    }

    public ListNode reverseFromHead(ListNode head, int m) {
        if (m == 1) {
            finallyNode = head.next;
            return head;
        }
        ListNode nextHead = reverseFromHead(head.next, m - 1);
        head.next.next = head;
        head.next = finallyNode;
        return nextHead;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = new LeetCode92反转链表2().reverseBetween2(node1, 2, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
