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

    /**
     * 二刷天际线问题 扫描线
     *
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline2(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] builds = new int[buildings.length * 2][2];
        int index = 0;
        for (int[] build : buildings) {
            int[] left = {build[0], build[2]};
            int[] right = {build[1], -build[2]};
            builds[index++] = left;
            builds[index++] = right;
        }
        Arrays.sort(builds, ((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int[] array : builds) {
            if (array[1] > 0) {
                if (pq.isEmpty() || array[1] > pq.peek()) {
                    List<Integer> point = new ArrayList<>();
                    point.add(array[0]);
                    point.add(array[1]);
                    result.add(point);
                }
                pq.offer(array[1]);
            } else {
                pq.remove(-array[1]);
                if (pq.isEmpty() || pq.peek() < -array[1]) {
                    List<Integer> point = new ArrayList<>();
                    point.add(array[0]);
                    point.add(pq.isEmpty() ? 0 : pq.peek());
                    result.add(point);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<List<Integer>> result = new LeetCode218天际线问题().getSkyline2(buildings);
        for (List<Integer> array : result) {
            for (int a : array) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
