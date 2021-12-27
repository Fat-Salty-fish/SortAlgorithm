package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/25
 */
public class LeetCode277搜寻名人 {

    /**
     * 这个方法只是为了编译通过
     * 实际上这个方法不需要实现
     *
     * @param a
     * @param b
     * @return
     */
    public boolean knows(int a, int b) {
        return a > b;
    }

    /**
     * 这个入参n是什么意思？
     * 应该是指有n个人参加派对 矩阵大小为n*n
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (knows(result, i)) {
                result = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == result) {
                continue;
            }
            if (knows(result, i)) {
                return -1;
            }
            if (!knows(i, result)) {
                return -1;
            }
        }
        return result;
    }
}
