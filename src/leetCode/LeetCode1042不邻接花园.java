package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/1
 */
public class LeetCode1042不邻接花园 {


    /**
     * @param n
     * @param paths
     * @return
     */
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 转换为Map保存
        for (int i = 0; i < paths.length; i++) {
            int left = paths[i][0];
            int right = paths[i][1];
            List<Integer> leftTarget = map.getOrDefault(left, new ArrayList<>());
            leftTarget.add(right);
            map.put(left, leftTarget);
            List<Integer> rightTarget = map.getOrDefault(right, new ArrayList<>());
            rightTarget.add(left);
            map.put(right, rightTarget);
        }
        // 每个花园要种的花的颜色 颜色只能是1-4之间
        int[] result = new int[n];
        Arrays.fill(result, -1);
        // 对每个花园尝试种植
        for (int i = 1; i <= n; i++) {
            List<Integer> targetGarden = map.getOrDefault(i, new ArrayList<>());
            boolean[] color = new boolean[5];
            Arrays.fill(color, true);
            for (int j : targetGarden) {
                // j就是和此花园相连的花园位置 先获取此位置的颜色
                // 如果这个地方没有颜色 就不处理 如果有颜色 就置为不能用
                int currentColor = result[j - 1];
                if (currentColor != -1) {
                    color[currentColor] = false;
                }
            }
            for (int j = 1; j <= 4; j++) {
                if (color[j]) {
                    result[i - 1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] array = new int[][]{{1, 2}, {2, 3}, {3, 1}};
        int[] result = new LeetCode1042不邻接花园().gardenNoAdj(n, array);
        System.out.println(result);
    }
}
