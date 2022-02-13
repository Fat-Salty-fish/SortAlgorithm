package others;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class Temp {

    class OrderedStream {

        String[] array;

        int ptr;

        public OrderedStream(int n) {
            array = new String[n + 1];
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            array[idKey] = value;
            List<String> result = new ArrayList<>();
            while (ptr < array.length && array[ptr] != null) {
                result.add(array[ptr++]);
            }
            return result;
        }
    }


    /**
     * LFU 之前做过 再尝试一下吧
     */
    static class LFUCache {

        /**
         * 原本保存key-value的map
         */
        Map<Integer, Integer> keyValueMap;

        /**
         * 用来保存key的频率的map
         */
        Map<Integer, Integer> keyCounterMap;

        /**
         * 用来保存使用频率-key的map
         * 这里应该如何保证在频率相同时 能够获取到最久的key？应该是一个有序的Set 有序保证了在相同频率下如果要删除最老的可以以O1时间复杂度获取
         * Set保证了删除的时候时间复杂度为O1
         */
        Map<Integer, LinkedHashSet<Integer>> counterKeyMap;

        /**
         * 当前容量大小
         */
        int size;

        /**
         * 最大容量大小
         */
        int capacity;

        /**
         * 当前最小频率
         */
        int minFrequency;

        public LFUCache(int capacity) {
            keyValueMap = new HashMap<>();
            keyCounterMap = new HashMap<>();
            counterKeyMap = new LinkedHashMap<>();
            size = 0;
            this.capacity = capacity;
            minFrequency = Integer.MAX_VALUE;
        }

        public int get(int key) {
            if (!keyValueMap.containsKey(key)) {
                return -1;
            }
            addFrequency(key);
            return keyValueMap.get(key);
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            if (keyValueMap.containsKey(key)) {
                addFrequency(key);
                keyValueMap.put(key, value);
                return;
            } else if (size < capacity) {
                addFrequency(key);
                keyValueMap.put(key, value);
                size++;
                return;
            }
            removeFromMap();
            keyValueMap.put(key, value);
            keyCounterMap.put(key, 1);
            LinkedHashSet<Integer> hashSet = counterKeyMap.getOrDefault(1, new LinkedHashSet<>());
            hashSet.add(key);
            counterKeyMap.put(1, hashSet);
            minFrequency = 1;
            size++;
        }


        /**
         * 增加某个key的使用频率记录 所有操作都必须是O(1)的
         *
         * @param key
         */
        public void addFrequency(int key) {
            if (!keyCounterMap.containsKey(key)) {
                keyCounterMap.put(key, 1);
                LinkedHashSet<Integer> hashSet = counterKeyMap.getOrDefault(1, new LinkedHashSet<>());
                hashSet.add(key);
                counterKeyMap.put(1, hashSet);
                minFrequency = 1;
                return;
            }
            int oldFrequency = keyCounterMap.get(key);
            // key-freqMap更新
            keyCounterMap.put(key, keyCounterMap.get(key) + 1);
            // freq-keyMap更新
            LinkedHashSet<Integer> hashSet = counterKeyMap.get(oldFrequency);
            hashSet.remove(key);
            if (hashSet.isEmpty()) {
                counterKeyMap.remove(oldFrequency);
                if (oldFrequency == minFrequency) {
                    minFrequency = oldFrequency + 1;
                }
            }
            LinkedHashSet<Integer> nowHashSet = counterKeyMap.getOrDefault(oldFrequency + 1, new LinkedHashSet<>());
            nowHashSet.add(key);
            counterKeyMap.put(oldFrequency + 1, nowHashSet);
        }

        /**
         * 从Map中删除一个元素
         */
        public void removeFromMap() {
            int key = counterKeyMap.get(minFrequency).iterator().next();
            keyValueMap.remove(key);
            keyCounterMap.remove(key);
            counterKeyMap.get(minFrequency).remove(key);
            if (counterKeyMap.get(minFrequency).isEmpty()) {
                counterKeyMap.remove(minFrequency);
            }
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        return null;
    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(3, 3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
