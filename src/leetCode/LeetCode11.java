package leetCode;

import sun.awt.HeadlessToolkit;

import javax.xml.stream.FactoryConfigurationError;

/**
 * @author acer
 * @Date 2019/7/24 23:27
 */
public class LeetCode11 {
//    给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
//    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
//    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//    示例:
//
//    输入: [1,8,6,2,5,4,8,3,7]
//    输出: 49
//    应该与动态规划类似

    public int maxArea(int[] height) {
        if (height == null || height.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
//            int area = (right - left) * (height[left]<height[right]?left:right);
//            if(max < area){
//                max = area;
//            }
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    /**
     * 重做11
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (j - i > 0) {
            int width = j - i;
            int currentHeight = Math.min(height[i], height[j]);
            int currentRes = width * currentHeight;
            res = Math.max(currentRes, res);
            // 思路:尽量寻找更高的墙 因为是从外向内寻找 所以宽度会越来越短 只能寻求更高的墙壁 只能在两个墙壁间保留更高的那个墙壁 才能有可能存水更多
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LeetCode11 leetCode11 = new LeetCode11();
        System.out.println(leetCode11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
