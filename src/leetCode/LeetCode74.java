package leetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author acer
 * @Date 2019/8/5 0:16
 */
public class LeetCode74 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList list = new ArrayList();
        ans.add(list);
        build(nums,ans,0,list);
        return ans;
    }

    //需要一个函数 传入数组以及所需要的个数 用来构造结果并向下传递
    public void build(int[] nums, List<List<Integer>> ans, int number, List<Integer> path) {
        if (number >= nums.length) {
            return;
        }
        List<Integer> current = new ArrayList<>(path);
        build(nums, ans, number + 1, current);
        current.add(nums[number]);
        ans.add(current);
        build(nums, ans, number + 1, current);
    }

    //二进制和位运算
    public List<List<Integer>> bit(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {       //代表有(2^n)个子集
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    current.add(nums[j]);
                }
            }
            ans.add(current);
        }
        return ans;
    }

    //从空集中逐步添加
    public List<List<Integer>> arrays(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        for (Integer num : nums) {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                List<Integer> current = new ArrayList<>(ans.get(i));
                current.add(num);
                ans.add(current);
            }
        }
        return ans;
    }
}
