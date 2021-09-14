package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/16
 */
public class LeetCode526优美的排列 {

    /**
     * 用于保存结果数组
     */
    public List<List<Integer>> resultArray = new ArrayList<>();

    /**
     * 优美的排列 看上去是一个规律题
     * 暴力好像太暴力了 回溯好像也是个不错的办法
     *
     * @param n
     * @return
     */
    public int countArrangement(int n) {
        dfs(n, 1, new HashSet<>());
        return resultArray.size();
    }

    /**
     * dfs 生成排列
     *
     * @param n
     * @param currentIndex
     * @param currentPath
     */
    public void dfs(int n, int currentIndex, Set<Integer> currentPath) {
        // 如果当前路径里已经有足够的元素
        if (currentPath.size() == n) {
            resultArray.add(new ArrayList<>(currentPath));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!currentPath.contains(i) && check(i, currentIndex)) {
                currentPath.add(i);
                dfs(n, currentIndex + 1, currentPath);
                currentPath.remove(i);
            }
        }
    }

    /**
     * 检查是否符合条件
     * 即第i个数能不能被i整除
     * 以及i能不能被第i个数整除
     *
     * @param n
     * @param i
     * @return
     */
    public boolean check(int n, int i) {
        return n % i == 0 || i % n == 0;
    }

    public static void main(String[] args) {
        int n = 3;
        int result = new LeetCode526优美的排列().countArrangement(n);
        System.out.println(result);
    }


}
