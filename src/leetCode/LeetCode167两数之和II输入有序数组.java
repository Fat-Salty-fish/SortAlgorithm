package leetCode;

/**
 * @author acer
 * @Date 2019/8/23 10:31
 */
public class LeetCode167两数之和II输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (j - i > 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                if (numbers[i] + numbers[j] == target) {
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                    break;
                }
            }
        }
        return ans;
    }

    public int[] twoPointer(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1,right+1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = new LeetCode167两数之和II输入有序数组().twoPointer(new int[]{2,7,11,15},9);
        for(int a : array){
            System.out.print(a);
        }
    }
}
