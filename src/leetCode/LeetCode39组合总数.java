package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/1
 */
public class LeetCode39组合总数 {

    /**
     * 动态规划特训
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target == 0) {
            return new ArrayList<>();
        }
        List[][] combination = new List[candidates.length][target + 1];
        int numSize = candidates.length;
        for (int i = 0; i < numSize; i++) {
            combination[i][0] = new ArrayList();
            combination[i][0].add(new ArrayList<>());
        }
        for (int i = 0; i < numSize; i++) {
            for (int j = 1; j <= target; j++) {
                if (candidates[i] <= j) {
                    List<List<Integer>> current = new ArrayList<>();
                    List<List<Integer>> first = new ArrayList<>();
                    if (i > 0) {
                        first = new ArrayList<>(combination[i - 1][j]);
                    }
                    current.addAll(first);
                    List<List<Integer>> second = new ArrayList<>(combination[i][j - candidates[i]]);
                    for (List<Integer> cur:second){
                        List<Integer> copy = new ArrayList<>(cur);
                        copy.add(candidates[i]);
                        current.add(copy);
                    }
                    combination[i][j] = current;
                } else {
                    combination[i][j] = i > 0 ? new ArrayList(combination[i - 1][j]) : new ArrayList();
                }
            }
        }
        return combination[candidates.length-1][target];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new LeetCode39组合总数().combinationSum(nums,target);
    }
}
