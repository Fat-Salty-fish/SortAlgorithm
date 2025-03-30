package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/2
 */
public class LeetCode127单词接龙 {

    /**
     * 用于保存wordList 转换为set
     */
    Set<String> wordSet;

    /**
     * 用于对字符串列表进行bfs时的queue
     */
    Queue<String> strQueue = new LinkedList<>();

    /**
     * 用于对字符串列表进行bfs时判断是否已经访问过的set
     */
    Set<String> visited = new HashSet<>();


    /**
     * wordList中的字符串长度相同
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        strQueue.offer(beginWord);
        visited.add(beginWord);

        int step = 1;

        // 对图进行bfs搜索
        while (!strQueue.isEmpty()) {
            int queueSize = strQueue.size();
            for (int i = 0; i < queueSize; i++) {
                String currentStr = strQueue.poll();
                if (check(currentStr, endWord)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 尝试对targetStr修改每一个字符 看看是不是能与endWord匹配
     *
     * @param targetStr
     * @return
     */
    public boolean check(String targetStr, String endWord) {
        char[] charArray = targetStr.toCharArray();
        for (int i = 0; i < targetStr.length(); i++) {
            char currentChar = charArray[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (currentChar == j) {
                    continue;
                }
                charArray[i] = j;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        strQueue.offer(nextWord);
                    }
                }
            }
            // 这里需要恢复
            charArray[i] = currentChar;
        }
        return false;
    }


    /**
     * 学习bfs之后自写
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordListSet = new HashSet<>(wordList);
        if (!wordListSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        // 首个单词也算一个 可以加在这里 也可以加在return时
        // int step = 1
        int step = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String currentStr = queue.poll();
                if (endWord.equals(currentStr)) {
                    // return step;
                    return step + 1;
                }
                char[] strCharArray = currentStr.toCharArray();
                for (int j = 0; j < strCharArray.length; j++) {
                    char currentChar = strCharArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == currentChar) {
                            continue;
                        }
                        strCharArray[j] = k;
                        String tempStr = String.valueOf(strCharArray);
                        if (!visited.contains(tempStr) && wordListSet.contains(tempStr)) {
                            visited.add(tempStr);
                            queue.offer(tempStr);
                        }
                        strCharArray[j] = currentChar;
                    }
                }
            }
            step++;
        }
        return 0;
    }


    /**
     * 单向BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordListSet = new HashSet<>(wordList);
        if (!wordListSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int result = 1;
        visited.add(beginWord);
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                // 对每一个位置进行遍历，更换一个字母
                for (int n = 0; n < current.length(); n++) {
                    for (int j = 0; j < 26; j++) {
                        char changed = (char) ('a' + j);
                        char[] currentArray = current.toCharArray();
                        currentArray[n] = changed;
                        String temp = String.valueOf(currentArray);
                        if (endWord.equals(temp)) {
                            return result + 1;
                        }
                        if (!visited.contains(temp) && wordListSet.contains(temp)) {
                            visited.add(temp);
                            queue.offer(temp);
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }

    /**
     * 双向BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordListSet = new HashSet<>(wordList);
        if (!wordListSet.contains(endWord)) {
            return 0;
        }
        // 需要两个Queue
        Set<String> leftSet = new HashSet<>();
        Set<String> rightSet = new HashSet<>();
        Set<String> visitedAll = new HashSet<>();
        leftSet.add(beginWord);
        rightSet.add(endWord);
        visitedAll.add(beginWord);
        visitedAll.add(endWord);
        int result = 2;
        // 条件为并，因为如果一个为空的话，表示无法相遇
        while (!leftSet.isEmpty() && !rightSet.isEmpty()) {
            // 总是遍历元素少的那一个
            if (rightSet.size() < leftSet.size()) {
                Set<String> temp = rightSet;
                rightSet = leftSet;
                leftSet = temp;
            }
            Set<String> nextSet = new HashSet<>();
            for (String currentString : leftSet) {
                for (int i = 0; i < currentString.length(); i++) {
                    char[] charOfCurrentString = currentString.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        // 元素相同，跳过
                        if (charOfCurrentString[i] == j){
                            continue;
                        }
                        charOfCurrentString[i] = j;
                        String tempString = String.valueOf(charOfCurrentString);
                        if (rightSet.contains(tempString)){
                            return result;
                        }
                        if (wordListSet.contains(tempString) && !visitedAll.contains(tempString)){
                            nextSet.add(tempString);
                            visitedAll.add(tempString);
                        }
                    }
                }
            }
            leftSet = nextSet;
            result++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        Integer result = new LeetCode127单词接龙().ladderLength4(beginWord, endWord, wordList);
        System.out.println(result);
    }
}
