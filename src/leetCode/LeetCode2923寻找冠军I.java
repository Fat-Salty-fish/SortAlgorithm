package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/4/12
 */
public class LeetCode2923寻找冠军I {

    public int findChampion(int[][] grid) {
        int size = grid.length;
        int result = -1;
        // 只要没有别的队比他强就行
        // 按列遍历
        for (int i = 0; i < size; i++) {
            boolean winner = true;
            for (int j = 0; j < size; j++) {
                if (grid[j][i] == 1){
                    winner = false;
                    break;
                }
            }
            if (winner){
                return i;
            }
        }
        return -1;
    }
}
