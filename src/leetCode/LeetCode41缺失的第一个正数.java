package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/2
 */
public class LeetCode41缺失的第一个正数 {

    /**
     * 交换位置
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int numLength = nums.length;
        for (int i = 0; i < numLength; i++) {
            int currentNum = nums[i];
            while (currentNum <= numLength && currentNum >= 1) {
                if (nums[currentNum - 1] == currentNum) {
                    break;
                } else {
                    int temp = nums[currentNum - 1];
                    nums[currentNum - 1] = currentNum;
                    nums[i] = temp;
                    currentNum = temp;
                }
            }
        }
        for (int i = 0; i < numLength; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return numLength + 1;
    }

    /**
     * 数组原地改造为哈希表
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        int numLength = nums.length;
        for (int i = 0; i < numLength; i++) {
            if (nums[i] <= 0) {
                nums[i] = numLength + 1;
            }
        }
        for (int i = 0; i < numLength; i++) {
            int currentAbs = Math.abs(nums[i]);
            if (currentAbs <= numLength) {
                nums[currentAbs - 1] = -Math.abs(nums[currentAbs - 1]);
            }
        }
        for (int i = 0; i < numLength; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return numLength + 1;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, -1, 1};
        int result = new LeetCode41缺失的第一个正数().firstMissingPositive2(array);
        System.out.println(result);
    }
}
