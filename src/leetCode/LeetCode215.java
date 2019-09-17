package leetCode;

import java.lang.reflect.Array;
import java.util.PriorityQueue;

/**
 * @author acer
 * @Date 2019/8/17 16:40
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    //快速选择法
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (true) {
            int position = partition(nums, left, right);
            if (position == k - 1) {
                //每一轮返回当前pivot的最终位置 它的位置就是第几大的 如果刚好是第k个大的数
                return nums[position];
            } else if (position > k - 1) {
                return position - 1;
            } else {
                left = position + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = left;
        //记住这里为left+1
        //因为基准为第left个数
        int l = left + 1;
        int r = right;
        while (l <= r) {
            //从左边开始找到第一个小于nums[pivot]的数
            while (l <= r && nums[l] >= nums[pivot]) {
                l++;
            }
            //从右边找到第一个大于nums[pivot]的数
            while (l <= r && nums[r] <= nums[pivot]) {
                r--;
            }
            if (l <= r && nums[l] < nums[pivot] && nums[r] > nums[pivot]) {
                swap(nums, l++, r--);
            }
        }
        swap(nums, pivot, r);
        return r;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode215().findKthLargest(new int[]{1,2,3,4,5},2));
    }
}
