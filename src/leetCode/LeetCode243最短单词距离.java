package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/3
 */
public class LeetCode243最短单词距离 {

    /**
     * 最短单词距离
     *
     * @param wordsDict
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int min = -1;
        int left = -1;
        int right = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                left = i;
            } else if (wordsDict[i].equals(word2) && left != -1) {
                min = min == -1 ? i - left : Math.min(min, i - left);
            }
        }
        for (int i = wordsDict.length - 1; i >= 0; i--) {
            if (wordsDict[i].equals(word1)) {
                right = i;
            } else if (wordsDict[i].equals(word2) && right != -1) {
                min = min == -1 ? right - i : Math.min(min, right - i);
            }
        }
        return min;
    }

    /**
     * 优化 只需要一次遍历
     *
     * @param wordsDict
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance2(String[] wordsDict, String word1, String word2) {
        int lastShow = -1;
        int min = -1;
        String lastWord = null;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                int last = lastShow;
                lastShow = i;
                if (lastWord != null && !lastWord.equals(wordsDict[i])) {
                    min = min == -1 ? lastShow - last : Math.min(min, lastShow - last);
                }
                lastWord = wordsDict[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] array = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        int result = new LeetCode243最短单词距离().shortestDistance(array, word1, word2);
        System.out.println(result);
    }
}
