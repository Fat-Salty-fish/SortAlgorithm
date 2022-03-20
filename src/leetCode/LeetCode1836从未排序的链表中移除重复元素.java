package leetCode;

import java.util.HashMap;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/14
 */
public class LeetCode1836从未排序的链表中移除重复元素 {

    /**
     * 不知道为啥没通过..
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            countMap.put(temp.val, countMap.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }
        temp = head;
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyTemp = dummyNode;
        while (temp != null) {
            if (countMap.get(temp.val) == 1){
                dummyTemp.next = temp;
                dummyTemp = dummyTemp.next;
            }
            temp = temp.next;
        }
        dummyTemp.next = null;
        return dummyNode.next;
    }
}
