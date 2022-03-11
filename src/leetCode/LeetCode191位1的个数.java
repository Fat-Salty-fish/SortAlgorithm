package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/11
 */
public class LeetCode191位1的个数 {
    /**
     * 最笨方法
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int move = 31; move >= 0; move--) {
            int temp = (n >> move) & 1;
            if (temp == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 减少遍历次数
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        int now = n;
        while (n != 0) {
            count++;
            now = now & (now - 1);
        }
        return count;
    }
}
