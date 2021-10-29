package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/28
 */
public class LeetCode254因子的组合 {

    /**
     * 动态规划特训
     *
     * @param n
     * @return
     */
    public List<List<Integer>> getFactors(int n) {
        return dfs(2, n);
    }

    /**
     * dfs解决
     *
     * @param start
     * @param n
     */
    public List<List<Integer>> dfs(int start, int n) {
        if (n == 1){
            return new ArrayList<>();
        }
        int sqrtOfN = (int) Math.sqrt(n);
        List<List<Integer>> resultPath = new ArrayList<>();
        for (int i = start; i <= sqrtOfN; i++) {
            if (n % i == 0) {
                List<Integer> currentPath = new ArrayList<>();
                currentPath.add(i);
                currentPath.add(n/i);
                resultPath.add(currentPath);
                List<List<Integer>> deep = dfs(i,n/i);
                for (List<Integer> temp:deep){
                    temp.add(i);
                    resultPath.add(temp);
                }
            }
        }
        return resultPath;
    }

    public static void main(String[] args) {
        int n = 12;
        List<List<Integer>> result = new LeetCode254因子的组合().getFactors(n);
        System.out.println("结果");
    }
}
