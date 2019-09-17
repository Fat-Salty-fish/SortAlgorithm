package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/8/8 23:36
 */
public class LeetCode47 {
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
                if(i>0 && nums[i] == nums[i-1] && !isExisted[i-1])
                    continue;
                path.push(nums[i]);
                isExisted[i] = true;
                build(ans,path,isExisted,currSize+1,num,nums);
                path.pop();
                isExisted[i] = false;
            }
        }
    }
}
