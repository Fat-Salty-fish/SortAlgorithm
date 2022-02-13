package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/2
 */
public class LeetCode218天际线问题 {


    /**
     * 类似于数飞机 不过权重变成了楼层高度
     *
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] array : buildings) {
            events.add(new int[]{array[0], array[2]});
            events.add(new int[]{array[1], -array[2]});
        }
        events.sort(((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> height = new PriorityQueue<>((o1, o2) -> o2 - o1);
        height.offer(0);
        int preMax = 0;
        for (int[] event : events) {
            if (event[1] > 0) {
                height.offer(event[1]);
            } else {
                height.remove(-event[1]);
            }
            int currentMax = height.peek();
            if (currentMax != preMax) {
                result.add(Arrays.asList(event[0], currentMax));
                preMax = currentMax;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] buildings = {{0,2,3},{2,5,3}};
        List<List<Integer>> result = new LeetCode218天际线问题().getSkyline(buildings);
    }
}
