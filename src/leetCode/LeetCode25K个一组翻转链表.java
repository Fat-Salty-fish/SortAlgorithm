package leetCode;

import com.sun.jmx.snmp.SnmpNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        Stack<ListNode> nodeStack = new Stack<>();
        List<ListNode> nodeList = new ArrayList<>();
        int num = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            while (num < k && tempNode != null) {
                nodeStack.push(tempNode);
                num++;
                ListNode curr = tempNode.next;
                tempNode.next = null;
                tempNode = curr;
            }
            if (num == k) {
                while (!nodeStack.isEmpty()) {
                    nodeList.add(nodeStack.pop());
                    num = 0;
                }
            } else {
                while (!nodeStack.isEmpty()) {
                    nodeList.addAll(nodeStack);
                    nodeStack.removeAllElements();
                }
            }
        }
        ListNode dummyNode = new ListNode(-1);
        tempNode = dummyNode;
        for (int i = 0; i < nodeList.size(); i++) {
            tempNode.next = nodeList.get(i);
            tempNode = tempNode.next;
        }
        return dummyNode.next;
    }


    //这个方法是用来反转链表的
    //k表示要反转的链表长度
    public ListNode reverse(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        int n = 0;
        ListNode endNode = null;
        while (head != null && n < k) {
            ListNode temp = dummyNode.next;
            ListNode remember = head.next;
            dummyNode.next = head;
            dummyNode.next.next = temp;
            head = remember;
            n++;
            endNode = remember;
        }
        ListNode node = dummyNode;
        while (node != null && node.next != null) {
            node = node.next;
        }
        node.next = endNode;
        return dummyNode.next;
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
        LeetCode25K个一组翻转链表 leetcode = new LeetCode25K个一组翻转链表();
        ListNode node = leetcode.reverseKGroup(node1, 5);
        System.out.println(node.val);
    }
}
