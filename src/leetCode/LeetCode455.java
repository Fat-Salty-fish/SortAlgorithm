package leetCode;

import java.util.Arrays;

/**
 * @author acer
 * @Date 2019/9/2 0:28
 */
public class LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int left = 0;
        int right = 0;
        while (left<g.length && right<s.length){
            if(g[left] <=s[right]){
                left++;
                ans++;
            }
            right++;
        }
        return ans;
    }
}
