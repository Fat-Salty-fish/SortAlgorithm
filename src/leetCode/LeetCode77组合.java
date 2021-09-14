package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/30
 */
public class LeetCode77组合 {

    /**
     * 结果数组
     */
    public List<List<Integer>> result = new ArrayList<>();

    /**
     * 组合
     * 简单dfs即可
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, new ArrayList<>(), 1);
        return result;
    }

    /**
     * dfs
     */
    public void dfs(int n, int k, List<Integer> currentPath, int currentNum) {
        if (currentPath.size() == k) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        // 当前数字已经超过了最大值 不再添加
        if (currentNum > n) {
            return;
        }
        int index = currentPath.size();
        for (int i = currentNum; i <= n; i++) {
            currentPath.add(i);
            dfs(n, k, currentPath, i + 1);
            currentPath.remove(index);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = new LeetCode77组合().combine(n, k);
        System.out.println(result);
    }
}
