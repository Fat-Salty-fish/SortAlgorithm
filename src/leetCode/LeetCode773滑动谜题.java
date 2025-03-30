package leetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode773滑动谜题 {

    private static int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * BFS专题的最后一道题！
     * 也是双源BFS
     * 转换为String来去重
     * 起始String就是二维数组构成的String
     * 结束String就是123450
     *
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        String start = buildStringAccordingToArray(board);
        String end = "123450";
        if (end.equals(start)) {
            return 0;
        }
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(start);
        endSet.add(end);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        visited.add(end);
        int steps = 0;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String current : startSet) {
                int[][] currentArray = buildArrayAccordingToString(current);
                int[] zeroPosition = getZeroPosition(currentArray);
                int currentX = zeroPosition[0];
                int currentY = zeroPosition[1];
                for (int[] direction : directions) {
                    int newX = currentX + direction[0];
                    int newY = currentY + direction[1];
                    if (newX >= 0 && newX < 2 && newY >= 0 && newY < 3) {
                        int[][] temp = buildArrayAccordingToString(current);
                        int tempNum = temp[currentX][currentY];
                        temp[currentX][currentY] = temp[newX][newY];
                        temp[newX][newY] = tempNum;
                        String tempString = buildStringAccordingToArray(temp);
                        if (endSet.contains(tempString)) {
                            return steps + 1;
                        }
                        if (!visited.contains(tempString)) {
                            nextLevel.add(tempString);
                            visited.add(tempString);
                        }
                    }
                }
            }
            startSet = nextLevel;
            steps++;
        }
        return -1;
    }


    private String buildStringAccordingToArray(int[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                builder.append(board[i][j]);
            }
        }
        return builder.toString();
    }

    private int[][] buildArrayAccordingToString(String string) {
        int[][] array = new int[2][3];
        for (int i = 0; i < string.length(); i++) {
            array[i / 3][i % 3] = Integer.parseInt(string.charAt(i) + "");
        }
        return array;
    }

    private int[] getZeroPosition(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
