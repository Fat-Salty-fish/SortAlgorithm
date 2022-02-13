package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/31
 */
public class LeetCode682棒球比赛 {


    public int calPoints(String[] ops) {
        List<Integer> records = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            String currentStr = ops[i];
            if ("+".equals(currentStr)) {
                records.add(records.get(records.size() - 1) + records.get(records.size() - 2));
            } else if ("D".equals(currentStr)) {
                records.add(2 * records.get(records.size() - 1));
            } else if ("C".equals(currentStr)) {
                records.remove(records.size() - 1);
            } else {
                Integer score = Integer.valueOf(currentStr);
                records.add(score);
            }
        }
        Integer result = records.stream().reduce(Integer::sum).get();
        return result;
    }
}
