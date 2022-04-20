package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/30
 */
public class AimToOffer15二进制中1的个数 {

    /**
     * 可以遍历32次 也可以只遍历1的个数次
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            int minus = n - 1;
            result++;
            n = n & minus;
        }
        return result;
    }
}
