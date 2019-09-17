package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author acer
 * @Date 2019/7/30 22:36
 */
public class LeetCode141 {
    //证明是否有环 添加到hashset中 可以证明是否曾经添加到了hashset中
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
