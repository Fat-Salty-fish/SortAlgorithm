package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/4/13
 */
public class LeetCode2924找到冠军II {


    public int findChampion(int n, int[][] edges) {
        boolean[] killed = new boolean[n];
        for (int i = 0; i< edges.length; i++){
            killed[edges[i][1]] = true;
        }

        int result = -1;
        int num = 0;
        for (int i = 0; i < killed.length; i++){
            if (!killed[i]){
                num ++;
                if (num > 1){
                    return -1;
                }
                result = i;
            }
        }
        return result;
    }
}
