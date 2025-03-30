package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3471找出最大的几近缺失整数 {

    public int largestInteger(int[] nums, int k) {
        if (k == 1) {
            int result = -1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    result = Math.max(result, entry.getKey());
                }
            }
            return result;
        } else if (k == nums.length) {
            int result = -1;
            for (int i = 0; i < nums.length; i++) {
                result = Math.max(result, nums[i]);
            }
            return result;
        }
        int result = -1;
        // answer will be nums[0] or nums[nums.length -1]
        int first = nums[0];
        int last = nums[nums.length - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(first, map.getOrDefault(first, 0) + 1);
        map.put(last, map.getOrDefault(last, 0) + 1);
        for (int i = 1; i < nums.length - 1; i++) {
            int current = nums[i];
            if (current == first || current == last) {
                map.put(current, map.getOrDefault(current, 0) + 1);
            }
        }
        int firstNum = map.get(first);
        int lastNum = map.get(last);
        if (firstNum > 1 && lastNum > 1) {
            return -1;
        } else if (firstNum == 1 && lastNum == 1) {
            return Math.max(first, last);
        } else if (lastNum == 1) {
            return last;
        } else {
            return first;
        }
    }
}
