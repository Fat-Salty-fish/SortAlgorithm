package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/3 15:25
 */
public class LeetCode1019链表中的下一个更大节点 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> array = new ArrayList<>();
        //将链表遍历 添加到array中
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        if (array.size() == 0) {
            return new int[0];
        }
        int[] ans = new int[array.size()];
//        ans[ans.length - 1] = 0;
        for (int i = ans.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= array.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(array.get(i));

        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        new LeetCode1019链表中的下一个更大节点().nextLargerNodes(head);
    }
}
