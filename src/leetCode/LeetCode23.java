package leetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/19 12:28
 */
public class LeetCode23 {

    //合并k个有序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //需要对数组进行预处理 将空数组剔除
        List<ListNode> myarray = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                myarray.add(lists[i]);
            }
        }
        if (myarray.size() == 0) {
            return null;
        }
        lists = new ListNode[myarray.size()];
        myarray.toArray(lists);
        ListNode ans = new ListNode(-1);
        ListNode head = ans;
        int length = lists.length;

        ListNode[] pointer = new ListNode[length];
        //为每一个链表都设置一个指针
        for (int i = 0; i < length; i++) {
            pointer[i] = lists[i];
            pointer[i] = lists[i];
        }
        //sum表示为总的节点数
        int sum = 0;
        //临时变量
        int count = 0;
        ListNode temp = lists[count];
        while (temp != null) {
            sum++;
            if (temp.next == null && count < lists.length - 1) {
                count++;
                temp = lists[count];
            } else {
                temp = temp.next;
            }
        }
        for (int i = 0; i < sum; i++) {
            ListNode node = new ListNode(Integer.MAX_VALUE);
            //寻找最小的节点
            int min = 0;
            for (int j = 0; j < length; j++) {
                if (pointer[j] != null) {
                    if (pointer[j].val < node.val) {
                        node = pointer[j];
                        min = j;
                    }
                }
            }
            //移动对应链表的指针
            pointer[min] = pointer[min].next;
            head.next = node;
            head = head.next;
        }
        return ans.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.length - 1);
    }

    public ListNode mergeList(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (end + start) / 2;
        ListNode node1 = mergeList(lists, start, mid);
        ListNode node2 = mergeList(lists, mid + 1, end);
        return mergeTwoList(node1, node2);
    }

    public ListNode mergeTwoList(ListNode node1, ListNode node2) {
        ListNode myHead = new ListNode(-1);
        ListNode temp = myHead;
        while (node1 != null || node2 != null) {
            if(node1 == null){
                temp.next = node2;
                node2 = node2.next;
            }else if(node2 == null){
                temp.next = node1;
                node1 = node1.next;
            }else if (node1.val <= node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        return myHead.next;
    }

    public static void main(String[] args) {
//        ListNode head1 = new ListNode(1);
//        ListNode node12 = new ListNode(4);
//        ListNode node13 = new ListNode(5);
//        head1.next = node12;
//        node12.next = node13;
//
//        ListNode head2 = new ListNode(1);
//        ListNode node22 = new ListNode(3);
//        ListNode node23 = new ListNode(4);
//        head2.next = node22;
//        node22.next = node23;
//
//        ListNode head3 = new ListNode(2);
//        ListNode node32 = new ListNode(6);
//        head3.next = node32;
//        ListNode[] array = new ListNode[]{head1,head2,head3};
//        new LeetCode23().mergeKLists(array);

//        ListNode head4 = null;
//        ListNode head5 = new ListNode(1);
//        new LeetCode23().mergeKLists(new ListNode[]{head4, head5});

        ListNode head6 = null;

        ListNode head7 = new ListNode(-1);
        ListNode node72 = new ListNode(5);
        ListNode node73 = new ListNode(11);
        head7.next = node72;
        node72.next = node73;

        ListNode head8 = null;

        ListNode head9 = new ListNode(6);
        ListNode node92 = new ListNode(10);
        head9.next = node92;

        new LeetCode23().mergeKLists(new ListNode[]{head6, head7, head8, head9});
    }
}
