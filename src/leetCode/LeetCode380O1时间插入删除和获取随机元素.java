package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/29
 */
public class LeetCode380O1时间插入删除和获取随机元素 {


    /**
     * 原题 作为内部类
     */
    class RandomizedSet {

        // 存放实际数字
        List<Integer> array;

        // 存放数字-index对应的下标
        Map<Integer, Integer> map;

        // 用于生成随机数
        Random random = new Random();

        public RandomizedSet() {
            array = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            // 将数字直接存入数组末尾 并记录元素所在index
            array.add(val);
            map.put(val, array.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            // 要删除的数字在array中的索引
            int indexOfRemoveNum = map.get(val);
            if (indexOfRemoveNum == array.size() - 1) {
                map.remove(val);
                array.remove(array.size() - 1);
                return true;
            }

            // 在map中也要删除这个数
            map.remove(val);

            // 和最后一位数进行交换
            int indexOfLast = array.size() - 1;
            int lastNum = array.get(array.size() - 1);


            array.set(indexOfRemoveNum, lastNum);
            array.set(indexOfLast, val);
            map.put(lastNum, indexOfRemoveNum);
            array.remove(indexOfLast);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(array.size());
            return array.get(index);
        }
    }
}
