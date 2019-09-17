package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author acer
 * @Date 2019/8/11 22:53
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode ans = null;
        Set<ListNode> set = new HashSet<>();
        ListNode current = head;
        while (current!=null){
            if(set.contains(current)){
                ans = current;
                return ans;
            }
            set.add(current);
            current = current.next;
        }
        return null;
    }
}
