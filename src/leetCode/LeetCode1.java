package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author acer
 * @Date 2019/7/25 0:09
 */
public class LeetCode1 {
    //两数之和
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num = 0; num < nums.length; num++) {
            //获取匹配当前数值的数是多少
            int complement = target - nums[num];
            //查询map中是否存在这样的数字
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement),num};
            }
            //存放时 key为自己的数字 value为下标。
            map.put(nums[num], num);
        }
        return null;
    }
}
