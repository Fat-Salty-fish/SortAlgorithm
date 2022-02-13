package leetCode;

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
        head.next = reverseBetween2(head.next, m - 1, n - 1);
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


    /**
     * 头条面试 三刷反转链表
     * 思路 先找到左边界 再反转到N
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween3(ListNode head, int m, int n) {
        // m == 1时 就是直接从头反转到n即可
        if (m == 1) {
            return reverseToN(head, n);
        }
        // 因为要返回头节点 此时头节点应该是head 只是head.next需要更新
        head.next = reverseBetween3(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 用于记录右边界之后剩余链表的头节点
     */
    private ListNode headLeftNode;

    /**
     * 从头开始反转 反转到第n个 返回头节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode reverseToN(ListNode head, int n) {
        if (n == 1) {
            headLeftNode = head.next;
            return head;
        }
        ListNode nextHead = reverseToN(head.next, n - 1);
        // 这个是反转链表的精髓 当前节点的next的节点的next指针 要指向当前节点 实现了反转 其实只需要反转当前节点即可
        head.next.next = head;
        // 当前节点会作为反转链表之后的最后一个节点 next节点直接指向剩余链表的头节点
        head.next = headLeftNode;
        return nextHead;
    }

    /**
     * 程序员面试指南
     * 再刷
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween4(ListNode head, int left, int right) {
        int length = 0;
        ListNode fromMinus = null;
        ListNode toPlus = null;
        ListNode temp = head;
        while (temp != null) {
            length++;
            fromMinus = length == left - 1 ? temp : fromMinus;
            toPlus = length == right + 1 ? temp : toPlus;
            temp = temp.next;
        }
        if (left > right || left < 1 || right > length) {
            return head;
        }
        temp = fromMinus == null ? head : fromMinus.next;
        ListNode temp2 = temp.next;
        temp.next = toPlus;
        ListNode next = null;
        while (temp2 != toPlus) {
            next = temp2.next;
            temp2.next = temp;
            temp = temp2;
            temp2 = next;
        }
        if (fromMinus != null) {
            fromMinus.next = temp;
            return head;
        }
        return temp;
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
        ListNode result = new LeetCode92反转链表2().reverseBetween4(node1, 2, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
