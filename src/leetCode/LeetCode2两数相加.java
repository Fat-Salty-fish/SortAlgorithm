package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/12/3
 */
public class LeetCode2两数相加 {
    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        Boolean needAdd = Boolean.FALSE;
        Integer addNum = 0;
        // 结果链的头呆节点
        ListNode dummyNode = new ListNode(-1);
        ListNode result = dummyNode;
        while (l1 != null || l2 != null || needAdd) {
            Integer addResult = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            ListNode currentNode = new ListNode(-1);
            if (needAdd) {
                addResult += addNum;
            }
            if (addResult >= 10) {
                currentNode.val = addResult % 10;
                needAdd = Boolean.TRUE;
                addNum = 1;
            } else {
                currentNode.val = addResult;
                needAdd = Boolean.FALSE;
                addNum = 0;
            }
            dummyNode.next = currentNode;
            dummyNode = dummyNode.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return result.next;
    }
}
