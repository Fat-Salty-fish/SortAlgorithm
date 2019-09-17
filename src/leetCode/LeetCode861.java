package leetCode;

/**
 * @author acer
 * @Date 2019/9/2 20:34
 */
public class LeetCode861 {
    public int matrixScore(int[][] A) {
        //用于保存结果
        int ans = 0;
        //宽度是多少 即有多少列
        int width = A[0].length;
        //高度是多少 即有多少行
        int height = A.length;
        //对于每一列
        for (int i = 0; i < width; i++) {
            //用于计算一行的结果
            int col = 0;
            for (int j = 0; j < height; j++) {
                //计算当前列1或者0的个数
                col +=  A[j][i] ^ A[j][0];
            }
            //计算这一列的和
            ans += Math.max(col,height-col) * (1 << (width - 1 - i));
        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode861().matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{0,0,1,1}});
    }
}
