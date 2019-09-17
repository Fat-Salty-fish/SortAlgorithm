package aimToOffer.merge;

/**
 * @author acer
 * @Date 2019/4/10 22:14
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        //用来进行运算的节点
        ListNode head = new ListNode(0);
        //用来返回的链表头节点 返回时直接返回这个节点的下一个节点即可
        ListNode node = head;

        if(list1 == null) {
            return list2;
        }

        if(list2 == null){
            return list1;
        }
        //遍历两个链表 要求两个指针指向的只要有一个不为空即可


        while (list1 != null || list2 != null) {
            if (list1 == null) {
                ListNode current  = new ListNode(list2.val);
                node.next = current;
                node = node.next;
                list2 = list2.next;
            } else if (list2 == null) {
                ListNode current  = new ListNode(list1.val);
                node.next = current;
                node = node.next;
                list1 = list1.next;
            }//如果一号链表指针的当前值小于等于二号链表指针的当前值 即赋一号链表的值
            //否则赋二号链表的值 满足链表单调不减
            else if (list1.val <= list2.val) {
                ListNode current  = new ListNode(list1.val);
                node.next = current;
                node = node.next;
                list1 = list1.next;
            } else if (list2.val <= list1.val) {
                ListNode current  = new ListNode(list2.val);
                node.next = current;
                node = node.next;
                list2 = list2.next;
            }
        }

        return head.next;
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

        ListNode node10 = new ListNode(10);
        ListNode node20 = new ListNode(20);
        ListNode node30 = new ListNode(30);
        ListNode node40 = new ListNode(40);
        ListNode node50 = new ListNode(50);
        node10.next = node20;
        node20.next = node30;
        node30.next = node40;
        node40.next = node50;

        ListNode nullNode = null;

        ListNode node = new Solution().Merge(node1, node10);



        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
