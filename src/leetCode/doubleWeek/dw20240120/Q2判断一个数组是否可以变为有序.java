package leetCode.doubleWeek.dw20240120;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/1/21
 */
public class Q2判断一个数组是否可以变为有序 {
    public boolean canSortArray(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int[] numsWithOne = Arrays.stream(nums).map(this::count).toArray();
        // 双指针 先对数组按照相同的位数进行排序，然后对比相邻分组的最大值和最小值
        int i = 0;
        int j = i + 1;
        while (i < nums.length && j < nums.length) {
            while (j < nums.length) {
                if (numsWithOne[i] != numsWithOne[j]) {
                    Arrays.sort(nums, i, j);
                    i = j;
                    break;
                }
                j++;
            }
        }
        Arrays.sort(nums, i, j);

        for (int x = 0; x < nums.length - 1; x++) {
            if (nums[x] > nums[x + 1]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 计算数字转化为二进制下的1的数量
     *
     * @param num
     * @return
     */
    public int count(int num) {
        if (num == 0) {
            return 0;
        }
        int numOfOne = 0;
        int position = 1;
        while (num > 0) {
            if ((num & position) == 1) {
                numOfOne++;
            }
            num >>= 1;
        }
        return numOfOne;
    }
}
