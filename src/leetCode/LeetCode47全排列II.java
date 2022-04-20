package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/8/8 23:36
 */
public class LeetCode47全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        boolean[] isExisted = new boolean[nums.length];
        //对数组进行一次排序
        Arrays.sort(nums);
        //调用构造结果的方法
        build(ans, new Stack<>(), isExisted, 0, nums.length, nums);
        return ans;
    }

    public void build(List<List<Integer>> ans, Stack<Integer> path, boolean[] isExisted, int currSize, int num, int[] nums) {
        if (currSize == num) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < num; i++) {
            if (!isExisted[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !isExisted[i - 1])
                    continue;
                path.push(nums[i]);
                isExisted[i] = true;
                build(ans, path, isExisted, currSize + 1, num, nums);
                path.pop();
                isExisted[i] = false;
            }
        }
    }

    /**
     * 需要对结果进行排除 如果有重复的就不重复添加
     * 如何使用排序能够
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    public void dfs(int[] nums, List<Integer> currentPath, List<List<Integer>> result, boolean[] visited) {
        if (currentPath.size() == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            currentPath.add(nums[i]);
            dfs(nums, currentPath, result, visited);
            currentPath.remove(currentPath.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 4};
        List<List<Integer>> result = new LeetCode47全排列II().permuteUnique(nums);
        System.out.println(result.get(0).get(0));
    }
}
