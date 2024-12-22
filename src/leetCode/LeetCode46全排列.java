package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/8/7 11:11
 */
public class LeetCode46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isExisted = new boolean[nums.length];

        if (nums.length == 0) {
            return ans;
        }

        for (int i = 0; i < isExisted.length; i++) {
            isExisted[i] = false;
        }

        build(ans, isExisted, nums, new Stack<>(), 0, nums.length);

        return ans;
    }

    public void build(List<List<Integer>> ans, boolean[] isExisted, int[] nums, Stack<Integer> current, int curSize, int num) {
        if (curSize == num) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < num; i++) {
            if (!isExisted[i]) {
                current.push(nums[i]);
                isExisted[i] = true;
                build(ans, isExisted, nums, current, curSize + 1, num);
                current.pop();
                isExisted[i] = false;
            }
        }
    }

    /**
     * 微软面试一面 全排列
     * 如何将visited数组空间优化掉？
     * 用数组交换的方式
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(nums, new ArrayList<>(), resultList, 0);
        return resultList;
    }

    public void dfs(int[] nums, List<Integer> currentPath, List<List<Integer>> result, int currentIndex) {
        if (currentPath.size() == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        for (int i = currentIndex; i < nums.length; i++) {
            swap(nums, i, currentIndex);
            currentPath.add(nums[currentIndex]);
            dfs(nums, currentPath, result, currentIndex + 1);
            currentPath.remove(currentPath.size() - 1);
            swap(nums, i, currentIndex);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 空间再简化
     * @param nums
     * @return
     */
    public List<List<Integer>> permute3(int[] nums){
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        lessSpace(nums,result,0);
        return result;
    }


    public void lessSpace(int[] nums, List<List<Integer>> result, int currentIndex) {
        if (currentIndex == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }
        for (int i = currentIndex; i < nums.length; i++) {
            swap(nums, i, currentIndex);
            lessSpace(nums, result, currentIndex + 1);
            swap(nums, i, currentIndex);
        }
    }

    /**
     * 全排列 我理解是一个DFS
     * @param nums
     * @return
     */
    public List<List<Integer>> permute4(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs2(nums, new ArrayList<>(), result, 0);
        return result;
    }

    /**
     * DFS 但是需要知道当前有那些元素已经存放在数组中了
     * @param nums
     * @param currentPath
     * @param result
     * @param currentIndex
     * @return
     */
    public void dfs2(int[] nums, List<Integer> currentPath, List<List<Integer>> result, int currentIndex) {
        if (currentPath.size() == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return ;
        }
        for (int i = currentIndex; i < nums.length; i++){
            swap(nums, i, currentIndex);
            currentPath.add(nums[currentIndex]);
            dfs2(nums, currentPath, result, currentIndex + 1);
            currentPath.remove(currentPath.size() - 1);
            swap(nums, i, currentIndex);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        List<List<Integer>> list = new LeetCode46全排列().permute(array);
        for (List<Integer> current : list) {
            for (Integer temp : current) {
                System.out.print(" " + temp + " ");
            }
            System.out.println(" ");
        }
    }

}
