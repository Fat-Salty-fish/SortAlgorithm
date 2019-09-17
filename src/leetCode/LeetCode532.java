package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author acer
 * @Date 2019/8/24 14:12
 */
public class LeetCode532 {
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        if (nums == null || nums.length == 0 || k < 0) {
            return ans;
        }
        Map<Integer, Integer> map = new HashMap<>();
        //key用来保存数字 value用来保存出现次数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Set<Integer> set = map.keySet();
        for (int key : set) {
            int sub = k + key;
            //如果 k = 0
            if (sub == key) {
                //如果大于2 则表示存在一个数对 如果为0则表示不存在
                ans += (map.get(key) >= 2 ? 1 : 0);
            } else if (map.containsKey(sub)) {
                ans += 1;
            }
        }
        return ans;
    }
}
