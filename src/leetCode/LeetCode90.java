package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/26 12:45
 */
public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        caculate(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void caculate(int[] nums, List<List<Integer>> ans, List<Integer> current, int num) {
        ans.add(new ArrayList<>(current));
        for (int j = num; j < nums.length; j++) {
            if (j > num && nums[j - 1] == nums[j]) {
                continue;
            }
            current.add(nums[j]);
            caculate(nums, ans, current, j + 1);
            current.remove(current.size() - 1);
        }
    }
}
