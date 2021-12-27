package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/7
 */
public class LeetCode1431拥有最多糖果的孩子 {

    /**
     * 分发糖果
     * 微软面试模拟
     *
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || candies.length == 0) {
            return new ArrayList<>();
        }
        List<Boolean> resultList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        for (int i = 0; i < candies.length; i++) {
            resultList.add(candies[i] + extraCandies >= max);
        }
        return resultList;
    }
}
