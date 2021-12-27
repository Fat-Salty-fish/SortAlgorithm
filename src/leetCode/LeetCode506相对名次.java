package leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/2
 */
public class LeetCode506相对名次 {


    public String[] findRelativeRanks(int[] score) {
        Integer[] sort = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(sort,Comparator.reverseOrder());
        Map<Integer, Integer> scoreToIndexMap = new HashMap<>();
        for (int i = 0; i < sort.length; i++) {
            scoreToIndexMap.put(sort[i], i + 1);
        }
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int index = scoreToIndexMap.get(score[i]);
            if (index == 1){
                result[i] = "Gold Medal";
            }else if (index == 2){
                result[i] = "Silver Medal";
            }else if (index == 3){
                result[i] = "Bronze Medal";
            }else {
                result[i] = String.valueOf(index);
            }
        }
        return result;
    }
}
