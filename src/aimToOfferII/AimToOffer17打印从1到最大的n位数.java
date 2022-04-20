package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/30
 */
public class AimToOffer17打印从1到最大的n位数 {

    /**
     * 这他妈的...
     * 应该如何分析？有没有可能超过了int的最大值 还有异常判断
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int max = getMax(n);
        int[] result = new int[max - 1];
        for (int i = 1; i <= max; i++) {
            result[i - 1] = i;
        }
        return result;
    }


    /**
     * 获取n位数下的最大值
     *
     * @param n
     * @return
     */
    public int getMax(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= 10;
        }
        return result;
    }


}
