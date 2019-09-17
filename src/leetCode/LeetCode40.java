package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/26 15:57
 */
public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        caculate(candidates, ans, new ArrayList<>(), 0, target);
        return ans;
    }

    public void caculate(int[] nums, List<List<Integer>> ans, List<Integer> path, int num, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = num; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            if(i>num && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            caculate(nums, ans, path, num+1, target - nums[i]);
            path.remove(path.size() - 1);
        }
    }
}
