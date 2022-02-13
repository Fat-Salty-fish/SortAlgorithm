package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/17
 */
public class LeetCode932漂亮数组 {

    Map<Integer, int[]> mem = new HashMap<>();

    /**
     * 漂亮数组
     * 分治+记忆化
     *
     * @param n
     * @return
     */
    public int[] beautifulArray(int n) {
        return f(n);
    }

    public int[] f(int n) {
        if (mem.containsKey(n)) {
            return mem.get(n);
        }
        int[] ans = new int[n];
        if (n == 1) {
            ans[0] = 1;
        } else {
            int temp = 0;
            for (int each : f((n + 1) / 2)) {
                ans[temp] = each * 2 - 1;
                temp++;
            }
            for (int each : f(n / 2)) {
                ans[temp] = each * 2;
                temp++;
            }
        }
        mem.put(n, ans);
        return ans;
    }
}
