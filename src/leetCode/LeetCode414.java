package leetCode;

import java.lang.management.LockInfo;
import java.util.*;

/**
 * @author acer
 * @Date 2019/8/24 0:13
 */
public class LeetCode414 {
    public int thirdMax(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                queue.add(nums[i]);
                if (queue.size() > 3) {
                    queue.poll();
                }
            }
        }
        if (queue.size() < 3) {
            int size = queue.size();
            int ans = -1;
            for (int i = 0; i < size; i++) {
                ans = queue.poll();
            }
            return ans;
        }
        return queue.peek();
    }

    public int thirdNum(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int a : nums) {
            if (a > first) {
                third = second;
                second = first;
                first = a;
            } else if (a > second && a < first) {
                third = second;
                second = a;
            } else if (a > third && a < second) {
                third = a;
            }
        }
        return ((third == Long.MIN_VALUE) || (second == third)) ? (int) first : (int) third;
    }

    public static void main(String[] args) {
        new LeetCode414().thirdNum(new int[]{3,1,2});
    }
}
