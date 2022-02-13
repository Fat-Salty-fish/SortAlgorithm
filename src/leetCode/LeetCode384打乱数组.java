package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/31
 */
public class LeetCode384打乱数组 {


    static class Solution {

        public int[] array;

        public Solution(int[] nums) {
            array = nums;
        }

        public int[] reset() {
            return array;
        }

        /**
         * 如何打乱一个数组？
         *
         * @return
         */
        public int[] shuffle() {
            int[] result = new int[array.length];
            List<Integer> waiting = new ArrayList<>();
            for (int num : array) {
                waiting.add(num);
            }
            Random random = new Random();
            // 这一段可以优化 和数组的最后一位进行交换
            for (int i = 0; i < result.length; i++) {
                int temp = random.nextInt(waiting.size());
                result[i] = waiting.get(temp);
                waiting.remove(temp);
            }
            return result;
        }

        /**
         * 可以实现本地的元素交换
         * @return
         */
        public int[] shuffle2() {
            int[] result = Arrays.copyOf(array, array.length);
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                // 这里随机出来的是一个index
                int randomNum = random.nextInt(array.length - i);
                int temp = result[randomNum];
                result[randomNum] = result[array.length - i - 1];
                result[array.length - i - 1] = temp;
            }
            return result;
        }

    }

    public static void main(String[] args) {
        int[] array = {0, -12893, 128384};
        Solution solution = new Solution(array);
        int[] shuffle = solution.shuffle();
        System.out.println(shuffle[0]);
    }
}
