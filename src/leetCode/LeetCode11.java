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
        if(height == null || height.length<=0){
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right){
//            int area = (right - left) * (height[left]<height[right]?left:right);
//            if(max < area){
//                max = area;
//            }
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode11 leetCode11 = new LeetCode11();
        System.out.println(leetCode11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
