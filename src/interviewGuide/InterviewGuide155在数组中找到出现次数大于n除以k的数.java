package interviewGuide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/12
 */
public class InterviewGuide155在数组中找到出现次数大于n除以k的数 {

    /**
     * 获取频率数
     *
     * @param array
     * @param k
     * @return
     */
    public List<Integer> getNums(int[] array, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int temp : array) {
            if (numMap.containsKey(temp)) {
                numMap.put(temp, numMap.get(temp) + 1);
            } else if (numMap.size() < k - 1) {
                numMap.put(temp, 1);
            } else {
                // 相当于把当前的temp也删掉了
                minusNum(numMap);
            }
        }
        numMap = getRealNum(numMap, array);
        List<Integer> result = new ArrayList<>();
        int target = array.length / k;
        for (Map.Entry<Integer, Integer> temp : numMap.entrySet()) {
            if (temp.getValue() > target){
                result.add(temp.getKey());
            }
        }
        return result;
    }

    /**
     * 将map中的数字的数量全部减1
     * 如果数字的频率为0 删除这条记录
     *
     * @param numMap
     */
    public void minusNum(Map<Integer, Integer> numMap) {
        List<Integer> keyList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            value--;
            if (value == 0) {
                keyList.add(key);
            } else {
                numMap.put(key, value);
            }
        }
        for (int key : keyList) {
            numMap.remove(key);
        }
    }

    public Map<Integer, Integer> getRealNum(Map<Integer, Integer> existMap, int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int temp : array) {
            if (existMap.containsKey(temp)) {
                result.put(temp, result.getOrDefault(temp, 0) + 1);
            }
        }
        return result;
    }

}
