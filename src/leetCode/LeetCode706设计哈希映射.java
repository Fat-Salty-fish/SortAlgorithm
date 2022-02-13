package leetCode;

import java.util.LinkedList;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class LeetCode706设计哈希映射 {

    static class Pair {
        int key;
        int value;

        public Pair() {

        }

        public Pair(int _x, int _y) {
            key = _x;
            value = _y;
        }
    }

    static class MyHashMap {

        /**
         * 存储数据
         */
        LinkedList<Pair>[] array;

        /**
         * 一般寻找一个质数来作为base
         */
        public final int base = 769;

        public MyHashMap() {
            array = new LinkedList[base];
            for (int i = 0; i < base; i++) {
                array[i] = new LinkedList<>();
            }
        }

        public void put(int key, int value) {
            int hash = calculate(key);
            for (int i = 0; i < array[hash].size(); i++) {
                Pair node = array[hash].get(i);
                if (node.key == key) {
                    if (node.value == value) {
                        return;
                    }
                    node.value = value;
                    return;
                }
            }
            Pair pair = new Pair(key, value);
            array[hash].add(pair);
        }

        public int get(int key) {
            int hash = calculate(key);
            for (int i = 0; i < array[hash].size(); i++) {
                Pair node = array[hash].get(i);
                if (node.key == key) {
                    return node.value;
                }
            }
            return -1;
        }

        public void remove(int key) {
            int hash = calculate(key);
            int index = -1;
            for (int i = 0; i < array[hash].size(); i++) {
                Pair node = array[hash].get(i);
                if (node.key == key) {
                    index = i;
                }
            }
            if (index != -1) {
                array[hash].remove(index);
            }
        }

        public int calculate(int key) {
            return key == 0 ? 0 : (key % base);
        }
    }

    public static void main(String[] args) {
        int key = 970;
        int value = 538;
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(key,value);
    }
}
