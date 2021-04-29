package leetCode;

/**
 * @author lizhongjie
 * @desc 有几种做法:1. 翻转链表 先将入参的两个链表翻转后进行计算 如同题目2 得出逆序链表后翻转链表
 * 2.用两个链表生成两个Integer的值 然后相加 最后用Integer的值构造结果 时间复杂度为O(n) 空间复杂度为O(1)
 * 3.用两个栈来模拟逆序 最后再构造一个链表出来
 * 现在完成第二种与第三种方法
 * @create_time 2020/12/3
 */
public class LeetCode445两数相加II {
    /**
     * 两个链表生成两个int值相加后处理
     * 这种情况的限制是在链表长度超过10后转换数字失败(超过了int的最大值)
     * 不推荐
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        int firstValue = 0;
        int secondValue = 0;
        while (l1 != null){
            firstValue = firstValue * 10 + l1.val;
            l1 = l1.next;
        }
        while (l2 != null){
            secondValue = secondValue * 10 + l2.val;
            l2 = l2.next;
        }
        int addResult = firstValue + secondValue;
        ListNode dummyNode = new ListNode(-1);
        if (addResult == 0){
            ListNode currentNext = new ListNode(0);
            dummyNode.next = currentNext;
        } else {
            while (addResult != 0) {
                ListNode next = dummyNode.next;
                ListNode currentNext = new ListNode(addResult % 10);
                currentNext.next = next;
                dummyNode.next = currentNext;
                addResult = addResult / 10;
            }
        }
        return dummyNode.next;
    }

    /**
     * 用栈模拟逆序
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return null;
    }
}
