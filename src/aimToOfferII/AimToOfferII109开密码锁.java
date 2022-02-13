package aimToOfferII;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/3
 */
public class AimToOfferII109开密码锁 {

    public Character[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * bfs经典题目
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        List<String> deadEndList = Arrays.asList(deadends);
        Set<String> deadEndSet = new HashSet<>(deadEndList);
        if (deadEndSet.contains(target) || deadEndSet.contains("0000")) {
            return -1;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int steps = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String currentStr = queue.poll();
                if (target.equals(currentStr)) {
                    return steps;
                }
                char[] currentStrArray = currentStr.toCharArray();
                for (int j = 0; j < 4; j++) {
                    // 记录 用于撤回
                    Character currentChar = currentStrArray[j];
                    // 上一个值
                    currentStrArray[j] = lastNum(currentChar);
                    String lastStr = String.valueOf(currentStrArray);
                    if (!visited.contains(lastStr) && !deadEndSet.contains(lastStr)) {
                        queue.offer(lastStr);
                        visited.add(lastStr);
                    }
                    // 下一个值
                    currentStrArray[j] = nextNum(currentChar);
                    String nextStr = String.valueOf(currentStrArray);
                    if (!visited.contains(nextStr) && !deadEndSet.contains(nextStr)) {
                        queue.offer(nextStr);
                        visited.add(nextStr);
                    }
                    // 修复数组
                    currentStrArray[j] = currentChar;
                }
            }
            steps++;
        }
        return -1;
    }

    /**
     * 获取当前字符的下一个字符
     *
     * @param current
     * @return
     */
    public Character nextNum(Character current) {
        if (current < '9') {
            return nums[current - '0' + 1];
        } else {
            return nums[0];
        }
    }

    /**
     * 获取当前字符的上一个字符
     *
     * @param current
     * @return
     */
    public Character lastNum(Character current) {
        if (current == '0') {
            return nums[9];
        } else {
            return nums[current - '0' - 1];
        }
    }


    public static void main(String[] args) {
        String[] strArray = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        AimToOfferII109开密码锁 test = new AimToOfferII109开密码锁();
        int result = test.openLock(strArray, target);
        System.out.println(result);
    }
}
