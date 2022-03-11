package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/4
 */
public class LeetCode244最短单词距离II {

    static class WordDistance {

        String[] wordDict;

        /**
         * 记录两个String的距离
         * 两个String必然不相等
         */
        Map<String, HashMap<String, Integer>> record;

        /**
         * 构造函数
         * 是否要解决多次重复查询优化时间复杂度问题？
         *
         * @param wordsDict
         */
        public WordDistance(String[] wordsDict) {
            this.wordDict = wordsDict;
            record = new HashMap<>();
            buildRecord();
        }

        /**
         * 根据字符串构造RecordMap
         */
        void buildRecord() {
            if (wordDict == null || wordDict.length == 0) {
                return;
            }
            for (int i = 0; i < wordDict.length; i++) {
                String left = wordDict[i];
                for (int j = i + 1; j < wordDict.length; j++) {
                    String right = wordDict[j];
                    if (!left.equals(right)) {
                        int length = j - i;
                        HashMap<String, Integer> leftMap = record.getOrDefault(left, new HashMap<>());
                        int ori = leftMap.getOrDefault(right, -1);
                        ori = ori == -1 ? length : Math.min(ori, length);
                        leftMap.put(right, ori);
                        record.put(left, leftMap);

                        HashMap<String, Integer> rightMap = record.getOrDefault(right, new HashMap<>());
                        int rightOri = rightMap.getOrDefault(left, -1);
                        rightOri = rightOri == -1 ? length : Math.min(rightOri, length);
                        rightMap.put(left, rightOri);
                        record.put(right, rightMap);
                    }
                }
            }
        }

        /**
         * 检查两个字符串的最短距离
         *
         * @param word1
         * @param word2
         * @return
         */
        public int shortest(String word1, String word2) {
            if (word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty() || word1.equals(word2)) {
                return 0;
            }
            return record.get(word1).get(word2);
        }
    }

    /**
     * 优化 先将字符串的下标统计出来
     */
    static class WordDistance2 {

        Map<String, ArrayList<Integer>> indexMap;

        public WordDistance2(String[] wordsDict) {
            indexMap = new HashMap<>();
            for (int i = 0; i < wordsDict.length; i++) {
                ArrayList<Integer> index = indexMap.getOrDefault(wordsDict[i], new ArrayList<>());
                index.add(i);
                indexMap.put(wordsDict[i], index);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> word1List = indexMap.get(word1);
            List<Integer> word2List = indexMap.get(word2);
            int temp1Index = 0;
            int temp2Index = 0;
            int result = -1;
            while (temp1Index < word1List.size() && temp2Index < word2List.size()) {
                result = result == -1 ? Math.abs(word1List.get(temp1Index) - word2List.get(temp2Index)) : Math.min(result, Math.abs(word1List.get(temp1Index) - word2List.get(temp2Index)));
                if (word1List.get(temp1Index) < word2List.get(temp2Index)) {
                    temp1Index++;
                } else if (word1List.get(temp1Index) > word2List.get(temp2Index)) {
                    temp2Index++;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String[] array = {"practice", "makes", "perfect", "coding", "makes"};
        LeetCode244最短单词距离II.WordDistance2 test = new LeetCode244最短单词距离II.WordDistance2(array);
        int result = test.shortest("coding", "practice");
        System.out.println(result);
    }
}
