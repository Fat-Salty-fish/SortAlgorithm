package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author acer
 * @Date 2019/8/11 22:53
 */
public class LeetCode142II {
    public ListNode detectCycle(ListNode head) {
        ListNode ans = null;
        Set<ListNode> set = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (set.contains(current)) {
                ans = current;
                return ans;
            }
            set.add(current);
            current = current.next;
        }
        return null;
    }

    /**
     * 返回链表里环形链的头节点 如果没有环 则返回null
     * 拆分整个list 从链表头到环的头为x1 环的头到第一次相遇的点为x2 相遇的点到环的头为x3
     * 则 2(x1+x2)-(x1+x2) = x2+x3 得 x1=x3
     * 则只需要在第一次相遇时 慢节点回到链表头 同时快节点每次走1格即可
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 快慢指针
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        while (secondNode != null && secondNode.next != null) {
            if (firstNode == secondNode) {
                // 让其中一个节点返回头节点 两节点按照相同速度同时前进 相遇点即为重复环的头节点
                // 另一个节点必须多走一步 因为返回头节点时相当于已经走了一步 即 头节点到环链表头的距离等于第一次相遇节点的下一个节点到环链表头的距离
                firstNode = head;
                secondNode = secondNode.next;
                while (firstNode != secondNode){
                    firstNode = firstNode.next;
                    secondNode = secondNode.next;
                }
                return firstNode;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode result = new LeetCode142II().detectCycle2(node1);

    }
}
