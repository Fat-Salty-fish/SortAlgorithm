package leetCode;

/**
 * @author acer
 * @Date 2019/8/10 9:51
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = null;
        ans = new int[n][n];
        if (n == 0) {
            return ans;
        }
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 1;
        int target = n * n;
        while (num <= target) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = num++;
            }
            left++;
        }
        return ans;
    }
}
