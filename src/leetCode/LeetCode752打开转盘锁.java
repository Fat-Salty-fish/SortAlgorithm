package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode752打开转盘锁 {

    /**
     * 双向BFS
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> deadendsSet = Arrays.stream(deadends).collect(Collectors.toSet());
        if (deadendsSet.contains(target) || deadendsSet.contains("0000")) {
            return -1;
        }
        Set<String> leftSet = new HashSet<>();
        Set<String> rightSet = new HashSet<>();
        leftSet.add("0000");
        rightSet.add(target);
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        visited.add(target);
        int result = 0;
        while (!leftSet.isEmpty() && !rightSet.isEmpty()) {
            if (leftSet.size() > rightSet.size()) {
                Set<String> temp = leftSet;
                leftSet = rightSet;
                rightSet = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String current : leftSet) {
                for (int i = 0; i < 4; i++) {
                    char previous = current.charAt(i) == '0' ? '9' : (char) (current.charAt(i) - 1);
                    char next = current.charAt(i) == '9' ? '0' : (char) (current.charAt(i) + 1);
                    char[] previousCharArray = current.toCharArray();
                    char[] nextCharArray = current.toCharArray();
                    previousCharArray[i] = previous;
                    nextCharArray[i] = next;
                    String previousString = new String(previousCharArray);
                    String nextString = new String(nextCharArray);
                    if (rightSet.contains(previousString) || rightSet.contains(nextString)) {
                        return result + 1;
                    }
                    if (!deadendsSet.contains(previousString) && !visited.contains(previousString)) {
                        nextLevel.add(previousString);
                        visited.add(previousString);
                    }
                    if (!deadendsSet.contains(nextString) && !visited.contains(nextString)) {
                        nextLevel.add(nextString);
                        visited.add(nextString);
                    }
                }
            }
            leftSet = nextLevel;
            result++;
        }
        return -1;
    }
}
