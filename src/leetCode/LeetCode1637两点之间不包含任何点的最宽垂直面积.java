package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/7
 */
public class LeetCode1637两点之间不包含任何点的最宽垂直面积 {

    /**
     * 微软模拟面试
     * @param points
     * @return
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(Comparator.comparingInt(o -> o[0])));
        int result = 0;
        for (int i = 1;i<points.length;i++){
            int currentWidth = points[i][0] - points[i-1][0];
            result = Math.max(result,currentWidth);
        }
        return result;
    }
}
