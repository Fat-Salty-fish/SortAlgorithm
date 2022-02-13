package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/30
 */
public class LeetCode204计数质数 {


    /**
     * n的最大值为5*10的6次方 感觉这个数比较大 如果暴力搜索 时间复杂度会达到n*根号n 极限情况比较大
     * 要筛除一些数 先采用埃氏筛的方法
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int[] array = new int[n];
        Arrays.fill(array, 1);
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (array[i] == 1) {
                result++;
                // 这里需要特殊处理一下 必须要转换成long 否则i * i会变为复数影响判断
                // 这里为什么要从i的平方开始筛除？因为1*i 2*i 3*i都已经被筛除过了
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j = j + i) {
                        array[j] = 0;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 看题解说线性筛的时候 才感觉已经做过这题
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        List<Integer> primeNums = new ArrayList<>();
        int[] primes = new int[n];
        Arrays.fill(primes, 1);
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                primeNums.add(i);
            }
            for (int j = 0; j < primeNums.size() && i * primeNums.get(j) < n; j++) {
                primes[i * primeNums.get(j)] = 0;
                // 核心点 保证了被筛除的数字只会被筛除一次
                if (i % primeNums.get(j) == 0){
                    break;
                }
            }
        }
        return primeNums.size();
    }

    public static void main(String[] args) {
        int n = 499979;
        int result = new LeetCode204计数质数().countPrimes(n);
    }
}
