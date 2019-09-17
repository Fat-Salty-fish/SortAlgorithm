package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/26 12:37
 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        caculate(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void caculate(int[] nums, List<List<Integer>> ans, List<Integer> current, int i) {
        ans.add(new ArrayList<>(current));
        for (int j = i; j < nums.length; j++) {
            current.add(nums[j]);
            caculate(nums, ans, current, j + 1);
            current.remove(current.size() - 1);
        }
    }
}
