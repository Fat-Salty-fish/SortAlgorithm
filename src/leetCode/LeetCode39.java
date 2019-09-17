package leetCode;

import org.jcp.xml.dsig.internal.dom.ApacheCanonicalizer;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/26 12:32
 */
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        caculate(candidates, ans, target, 0, new ArrayList<>());
        return ans;
    }

    //current用来记录当前只和
    //num用来记录当前位于数组的位置
    public void caculate(int[] nums, List<List<Integer>> ans, int target, int num, List<Integer> path) {
        if(target < 0 ){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = num;i<nums.length;i++){
            if(nums[i] > target){
                break;
            }
            path.add(nums[i]);
            caculate(nums,ans,target-nums[i],i,path);
            path.remove(path.size()-1);
        }
    }
}
