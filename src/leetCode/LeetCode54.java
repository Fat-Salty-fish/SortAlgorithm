package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/10 17:38
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0 ){
            return ans;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        int size = m * n;
        int current = 0;
        while (current < size) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
                current++;
            }
            if(current == size){
                break;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
                current++;
            }
            if(current == size){
                break;
            }
            right--;
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
                current++;
            }
            if(current == size){
                break;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
                current++;
            }
            if(current == size){
                break;
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new LeetCode54().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        for(Integer i :list){
            System.out.println(i);
        }
    }
}
