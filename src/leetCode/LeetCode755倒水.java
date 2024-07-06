package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/1/20
 */
public class LeetCode755倒水 {


    public int[] pourWater(int[] heights, int volume, int k) {
        if (heights == null || heights.length == 0) {
            return heights;
        }
        if (heights.length == 1) {
            heights[0] += volume;
            return heights;
        }
        for (int i = volume; i > 0; i--) {
            consumeTheDropIntoHeight(heights, k);
        }
        return heights;
    }


    public void consumeTheDropIntoHeight(int[] height, int index) {
        int stayIndex = index;
        // left first, and then right.
        for (int i = index - 1; i >= 0; i--) {
            if (height[i] < height[stayIndex]) {
                stayIndex = i;
            } else if (height[i] == height[stayIndex]) {
                continue;
            } else {
                break;
            }
        }

        for (int i = stayIndex + 1; i < height.length; i++) {
            if (height[i] < height[stayIndex]) {
                stayIndex = i;
            } else if (height[i] == height[stayIndex]) {
                continue;
            } else {
                break;
            }
        }

        height[stayIndex]++;
    }

    public static void main(String[] args) {
        int [] test = new int[]{2,1,1,2,1,2,2};
        LeetCode755倒水 object = new LeetCode755倒水();
        int[] result = object.pourWater(test, 4,3);

        System.out.println(Arrays.toString(test));
    }
}
