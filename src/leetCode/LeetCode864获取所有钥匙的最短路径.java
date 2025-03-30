package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/3/1
 */
public class LeetCode864获取所有钥匙的最短路径 {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static class Point {
        int x;
        int y;

        boolean[][] visited;

        Set<Character> existedKeys;

        public Point(int x, int y, boolean[][] visited, Set<Character> existedKeys) {
            this.x = x;
            this.y = y;
            this.visited = visited;
            this.existedKeys = existedKeys;
        }

    }


    // Airbnb原题挂掉了
    public int shortestPathAllKeys(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        int startX = 0, startY = 0;
        // 用二进制来维护钥匙
        Map<Character, Integer> keys = new HashMap<Character, Integer>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i].charAt(j) == '@') {
                    startX = i;
                    startY = j;
                } else if (Character.isLowerCase(grid[i].charAt(j))) {
                    if (!keys.containsKey(grid[i].charAt(j))) {
                        int index = keys.size();
                        keys.put(grid[i].charAt(j), index);
                    }
                }
            }
        }

        // BFS
        Queue<int[]> queue = new LinkedList<>();
        // 三维visited 第三维保存了当前钥匙的个数
        // 为什么这个数组的结果可以记录步数？
        int[][][] visited = new int[rows][cols][1 << keys.size()];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }
        visited[startX][startY][0] = 0;
        queue.offer(new int[]{startX, startY, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                int currentKeys = current[2];
                for (int[] direction : directions) {
                    int newX = currentX + direction[0];
                    int newY = currentY + direction[1];
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX].charAt(newY) != '#') {
                        if (grid[newX].charAt(newY) == '.' || grid[newX].charAt(newY) == '@') {
                            if (visited[newX][newY][currentKeys] == -1) {
                                visited[newX][newY][currentKeys] = visited[currentX][currentY][currentKeys] + 1;
                                queue.offer(new int[]{newX, newY, currentKeys});
                            }
                        } else if (Character.isLowerCase(grid[newX].charAt(newY))) {
                            int keyIndex = keys.get(grid[newX].charAt(newY));
                            if (visited[newX][newY][currentKeys | 1 << keyIndex] == -1) {
                                visited[newX][newY][currentKeys | 1 << keyIndex] = visited[currentX][currentY][currentKeys] + 1;
                                if ((currentKeys | 1 << keyIndex) == (1 << keys.size()) - 1) {
                                    return visited[newX][newY][currentKeys | 1 << keyIndex];
                                }
                                queue.offer(new int[]{newX, newY, currentKeys | 1 << keyIndex});
                            }
                        } else if (Character.isUpperCase(grid[newX].charAt(newY))) {
                            char lock = Character.toLowerCase(grid[newX].charAt(newY));
                            int index = keys.get(lock);
                            if ((currentKeys & (1 << index)) != 0 && visited[newX][newY][currentKeys] == -1) {
                                visited[newX][newY][currentKeys] = visited[currentX][currentY][currentKeys] + 1;
                                queue.offer(new int[]{newX, newY, currentKeys});
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

}
