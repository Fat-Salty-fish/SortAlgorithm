package leetCode;

/**
 * @author acer
 * @Date 2019/9/1 23:55
 */
public class LeetCode944 {
    public int minDeletionSize(String[] A) {
        //贪心算法
        //对每一列
        int ans = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length; j++) {
                if(j > 0 && A[j].charAt(i) - 'a' < A[j-1].charAt(i) - 'a'){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
