package leetCode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/31
 */
public class LeetCode460LFU缓存 {

    class LFUCache {
        /**
         * 保存value数据
         */
        Map<Integer, Integer> storage;

        /**
         * 最大容量
         */
        Integer capacity;

        /**
         * 已经插入的值
         */
        Integer existedSize;

        /**
         * key->频率的map
         */
        Map<Integer, Integer> key2FreMap;

        /**
         * 当前最小的频率值
         */
        Integer lowestFre;

        /**
         * 频率->key的map
         */
        Map<Integer, LinkedHashSet<Integer>> fre2KeyMap;


        public LFUCache(int capacity) {
            storage = new HashMap<>();
            this.capacity = capacity;
            existedSize = 0;
            key2FreMap = new HashMap<>();
            lowestFre = Integer.MAX_VALUE;
            fre2KeyMap = new HashMap<>();
        }

        /**
         * 保证O(1)的时间复杂度
         * 同时要增加使用频率
         *
         * @param key
         * @return
         */
        public int get(int key) {
            if (!storage.containsKey(key)) {
                return -1;
            }
            Integer value = storage.get(key);
            increaseKeyFrequency(key);
            return value;
        }

        /**
         * 增加key的使用频率
         *
         * @param key
         */
        public void increaseKeyFrequency(Integer key) {
            // 获取原来的频率
            Integer currentFrequency = key2FreMap.get(key);
            // 修改key->fre map
            key2FreMap.put(key, currentFrequency + 1);
            // 从原来的fre->key map中删除key 这是个set 所以是o1
            fre2KeyMap.get(currentFrequency).remove(key);
            // 向新的fre->key map list中添加key
            fre2KeyMap.putIfAbsent(currentFrequency + 1, new LinkedHashSet<>());
            fre2KeyMap.get(currentFrequency + 1).add(key);
            // 如果原来的fre-key map中的链表为空了
            if (fre2KeyMap.get(currentFrequency).isEmpty()) {
                fre2KeyMap.remove(currentFrequency);
                // 如果最低频率是currentFrequency 则更新
                if (lowestFre.equals(currentFrequency)) {
                    lowestFre++;
                }
            }
        }

        /**
         * 保证O(1)的时间复杂度
         * 如果key存在 则覆盖值
         * 如果key不存在 则判断容量是否已经满
         * 如果容量未满 则直接插入
         * 如果容量已满 则判断使用频率 先删除使用频率最低的元素
         * 如果多个元素使用频率相同 则删除距离上一次使用最久的元素
         *
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            if (storage.containsKey(key)) {
                storage.put(key, value);
                increaseKeyFrequency(key);
            } else {
                if (existedSize < capacity) {
                    storage.put(key, value);
                    key2FreMap.put(key, 1);
                    fre2KeyMap.putIfAbsent(1, new LinkedHashSet<>());
                    fre2KeyMap.get(1).add(key);
                    lowestFre = 1;
                    existedSize++;
                } else {
                    // 判断使用频率 并根据使用频率删除key 需要先删除再添加
                    // 如何用O（1）的时间来判断使用频率最低的key是哪一个？
                    removeFromLFU();
                    storage.put(key, value);
                    key2FreMap.put(key, 1);
                    fre2KeyMap.putIfAbsent(1, new LinkedHashSet<>());
                    fre2KeyMap.get(1).add(key);
                    lowestFre = 1;
                    existedSize++;
                }
            }
        }

        public void removeFromLFU() {
            LinkedHashSet hashSet = fre2KeyMap.get(lowestFre);
            Integer key = (Integer) hashSet.iterator().next();
            storage.remove(key);
            key2FreMap.remove(key);
            hashSet.remove(key);
            if (hashSet.isEmpty()){
                fre2KeyMap.remove(lowestFre);
            }
        }
    }
}
