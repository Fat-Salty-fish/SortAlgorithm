package leetCode;

import java.util.ArrayList;

/**
 * @author acer
 * @Date 2019/7/29 18:29
 */
public class LeetCode109有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        return build(array, 0, array.length);
    }

    public TreeNode build(Integer[] array, int start, int end) {
        TreeNode node = null;
        //证明有节点是属于这一棵树的
        if (end - start > 0) {
            int temp = (start + end) / 2;
            node = new TreeNode(array[temp]);
            node.left = build(array, start, temp);
            node.right = build(array, temp + 1, end);
        }
        return node;
    }

    /**
     * 微软模拟面试
     * 从中间进行划分
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slowLast = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slowLast = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNode = slow;
        slowLast.next = null;
        TreeNode currentNode = new TreeNode(midNode.val);
        ListNode next = midNode.next;
        currentNode.left = sortedListToBST2(head);
        currentNode.right = sortedListToBST2(next);
        return currentNode;
    }

    /**
     * 左开右闭
     *
     * @param head
     * @param tail
     * @return
     */
    public TreeNode sortedListToBSTWithStartAndEnd(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode mid = null;
        return null;
    }

    /**
     * 获取链表的中点
     *
     * @param head
     * @return
     */
    public ListNode getMidNodeAndLast(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(-10);
        ListNode second = new ListNode(-3);
        first.next = second;
        ListNode third = new ListNode(0);
//        second.next = third;
        ListNode forth = new ListNode(5);
//        third.next = forth;
        ListNode fifth = new ListNode(9);
//        forth.next = fifth;
        ListNode mid = new LeetCode109有序链表转换二叉搜索树().getMidNodeAndLast(first);
        System.out.println("运行结束了");
    }


    /**
     * 将字符串分隔成3个部分
     * 求能分隔成3个部分并且每个部分含有数字1的个数相同的方案
     *
     * @param s
     * @return
     */
    public int numWays(String s) {
        if (s == null || s.length() < 3) {
            return 0;
        }
        int stringLength = s.length();
        int[] mem = new int[stringLength + 1];
        for (int i = 1; i <= stringLength; i++) {
            mem[i] = mem[i - 1] + s.charAt(i - 1) == '1' ? 1 : 0;
        }
        int left = 1;
        int right = stringLength - 1;
        int result = 0;
        boolean moveLeftOrRight = false;
        while (left != right) {
            int leftStringNum = mem[left];
            int midStringNum = mem[right] - mem[left];
            int rightStringNum = mem[stringLength] - mem[right];
            if (leftStringNum == midStringNum && leftStringNum == rightStringNum) {
                result++;
            }
            if (moveLeftOrRight){
                right--;
            }else {
                left++;
            }
            moveLeftOrRight = !moveLeftOrRight;
        }
        return result;
    }

}
