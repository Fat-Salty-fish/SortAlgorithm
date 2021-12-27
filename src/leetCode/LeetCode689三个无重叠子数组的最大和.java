package leetCode;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/8
 */
public class LeetCode689三个无重叠子数组的最大和 {


    /**
     * 动态规划
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        /**
         * 有效数组范围
         */
        int n = nums.length - k + 1;


        // 前缀和 帮助计算以i为结尾的子数组的和
        int[] sum = new int[nums.length];
        // dp[i]表示以i为开头的子数组的和
        int[] dpSum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dpSum[i] = sum[i + k - 1];
            } else {
                dpSum[i] = sum[i + k - 1] - sum[i - 1];
            }
        }

        // 从左到右数 子数组和最大的起始位置
        int[] leftMax = new int[n];
        // 从右往左数 子数组和最大的起始位置
        int[] rightMax = new int[n];

        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dpSum[i] > dpSum[maxIndex]) {
                maxIndex = i;
            }
            leftMax[i] = maxIndex;
        }

        maxIndex = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (dpSum[i] >= dpSum[maxIndex]) {
                maxIndex = i;
            }
            rightMax[i] = maxIndex;
        }

        int[] result = new int[3];
        Arrays.fill(result, -1);
        // 因为这里需要的是index 所以leftMax和rightMax不能保存具体的和 只能保存index
        for (int i = k; i < n - k; i++) {
            if (result[0] == -1 || dpSum[result[0]] + dpSum[result[1]] + dpSum[result[2]] < dpSum[i] + dpSum[leftMax[i - k]] + dpSum[rightMax[i + k]]) {
                result[0] = leftMax[i - k];
                result[1] = i;
                result[2] = rightMax[i + k];
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
//        int[] array = {1, 2, 1, 2, 1, 2, 1, 2, 1};
//        int n = 2;
//        int[] result = new LeetCode689三个无重叠子数组的最大和().maxSumOfThreeSubarrays(array, n);
//        System.out.println(result);
        ArrayList<Integer> arrayList = new ArrayList<>(10);
        System.out.println(arrayList.size());

    }
}
