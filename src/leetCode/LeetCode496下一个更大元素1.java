package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/3 19:47
 */
public class LeetCode496下一个更大元素1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        //用一个map来保存
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            //栈顶元素小于当前元素
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }



    public static void main(String[] args) {
        for (int a : new LeetCode496下一个更大元素1().nextGreaterElement(new int[]{3,4,2}, new int[]{1, 3, 4, 2})) {
            System.out.println(a);
        }
    }
}
