package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/7
 */
public class LeetCode451根据字符出现频率排序 {

    /**
     * 微软模拟面试
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 统计出现频率
        Map<Character, Integer> frequency = new HashMap<>();
        for (Character a : s.toCharArray()) {
            if (frequency.containsKey(a)) {
                frequency.put(a, frequency.get(a) + 1);
            } else {
                frequency.put(a, 1);
            }
        }
        StringBuilder builder = new StringBuilder();
        frequency.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(o1 -> {
            Character current = o1.getKey();
            for (int i = 0; i < o1.getValue(); i++) {
                builder.append(current);
            }
        });
        return builder.toString();
    }
}
