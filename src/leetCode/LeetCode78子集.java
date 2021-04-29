package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/26 12:37
 */
public class LeetCode78子集 {
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

    /**
     * 二刷子集
     * 回溯算法
     * 子集就是向现有的结果集的每一个集合中添加当前元素
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            List<List<Integer>> currentRes = new ArrayList<>();
            for (int j = 0; j < res.size(); j++) {
                List<Integer> cur = new ArrayList<>(res.get(j));
                cur.add(currentNum);
                currentRes.add(cur);
            }
            res.addAll(currentRes);
        }
        return res;
    }

    /**
     * 三刷子集
     * 回溯算法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets3(int[] nums){

    }
}
