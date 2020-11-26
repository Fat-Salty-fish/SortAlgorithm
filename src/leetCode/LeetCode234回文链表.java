package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/11/24
 */
public class LeetCode234回文链表 {

    /**
     * 判断一个链表是否为回文链表
     * 思路：先计算这个链表的长度
     * 再将这个链表前半部分进行翻转
     * 再进行比对即可
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        // 快慢节点用于得到链表中心位置的节点
        ListNode firstHead = head;
        ListNode secondHead = head;
        while (null != firstHead.next) {
            firstHead = firstHead.next;
            if (null != firstHead.next) {
                firstHead = firstHead.next;
                secondHead = secondHead.next;
            }
        }
        // 此时 快指针已经指向了链表的尾节点 慢指针已经指向了链表的中间指针
        // 翻转后半部分的链表
        ListNode firstList = head;
        ListNode secondList = reverseList(secondHead);

        // 奇数个数时 链表的最后一个节点都是相同节点
        // 偶数个数时 一个链表的节点会多于另一个链表的节点
        boolean result = true;
        while (result && null != firstList && null != secondList) {
            result = result && (firstList.val == secondList.val);
            firstList = firstList.next;
            secondList = secondList.next;
        }
        return result;
//        // 计算链表长度
//        Integer lengthOfList = getListLength(head);
//        if (lengthOfList % 2 == 0){
//
//        }
    }

    public Integer getListLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return 1;
        }
        return 1 + getListLength(head.next);
    }


    /**
     * 翻转链表 返回翻转链表后的头节点
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    public static void main(String[] args) {
        // 偶数个
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);

        // 奇数个
        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(3);
        ListNode node10 = new ListNode(2);
        ListNode node11 = new ListNode(1);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;


        LeetCode234回文链表 leetCode = new LeetCode234回文链表();

        boolean palindrome = leetCode.isPalindrome(node1);
        palindrome = leetCode.isPalindrome(node7);

    }

}
