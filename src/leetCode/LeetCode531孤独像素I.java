package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/6
 */
public class LeetCode531孤独像素I {

    /**
     * 孤独像素
     * 看起来像是用dp来解决
     *
     * @param picture
     * @return
     */
    public int findLonelyPixel(char[][] picture) {
        int rowNum = picture.length;
        int colNum = picture[0].length;
        int[][] up = new int[rowNum][colNum];
        int[][] down = new int[rowNum][colNum];
        int[][] left = new int[rowNum][colNum];
        int[][] right = new int[rowNum][colNum];

        // 预处理 先从左到右 从上到下
        // 在从右到左 从下到上
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                int upNum = i == 0 ? 0 : up[i - 1][j];
                int leftNum = j == 0 ? 0 : left[i][j - 1];
                up[i][j] = picture[i][j] == 'B' ? upNum + 1 : upNum;
                left[i][j] = picture[i][j] == 'B' ? leftNum + 1 : leftNum;
            }
        }

        for (int i = rowNum - 1; i >= 0; i--) {
            for (int j = colNum - 1; j >= 0; j--) {
                int downNum = i == rowNum - 1 ? 0 : down[i + 1][j];
                int rightNum = j == colNum - 1 ? 0 : right[i][j + 1];
                boolean currentPic = picture[i][j] == 'B';
                down[i][j] = currentPic ? downNum + 1 : downNum;
                right[i][j] = currentPic ? rightNum + 1 : rightNum;
            }
        }
        int result = 0;
        // 遍历picture
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                boolean currentPic = picture[i][j] == 'B';
                int currentUp = i == 0 ? 0 : up[i - 1][j];
                int currentLeft = j == 0 ? 0 : left[i][j - 1];
                int currentDown = i == rowNum - 1 ? 0 : down[i + 1][j];
                int currentRight = j == colNum - 1 ? 0 : right[i][j + 1];
                if (currentPic && currentUp == 0 && currentLeft == 0 && currentDown == 0 && currentRight == 0) {
                    result++;
                }
            }
        }
        return result;
    }
    
}
