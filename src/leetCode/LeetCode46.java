package leetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.spi.CurrencyNameProvider;

/**
 * @author acer
 * @Date 2019/8/7 11:11
 */
public class LeetCode46 {
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
            if(!isExisted[i]){
                current.push(nums[i]);
                isExisted[i] = true;
                build(ans,isExisted,nums,current,curSize+1,num);
                current.pop();
                isExisted[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        List<List<Integer>> list = new LeetCode46().permute(array);
        for(List<Integer> current:list){
            for(Integer temp:current){
                System.out.print(" "+temp+" ");
            }
            System.out.println(" ");
        }
    }

}
