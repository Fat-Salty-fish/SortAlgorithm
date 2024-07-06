package leetCode;

import java.util.LinkedList;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class LeetCode705设计哈希集合 {


    class MyHashSet {

        private final int base = 769;

        private LinkedList[] array;

        public MyHashSet() {
            array = new LinkedList[base];
            for (int i = 0; i < base; i++) {
                array[i] = new LinkedList();
            }
        }

        public void add(int key) {
            int head = getHash(key);
            for (int i = 0; i < array[head].size(); i++) {
                int temp = (int) array[head].get(i);
                if (temp == key) {
                    return;
                }
            }
            array[head].add(key);
        }

        public void remove(int key) {
            int head = getHash(key);
            int target = -1;
            for (int i = 0; i < array[head].size(); i++) {
                int temp = (int) array[head].get(i);
                if (temp == key) {
                    target = i;
                }
            }
            if (target != -1) {
                array[head].remove(target);
            }
        }

        public boolean contains(int key) {
            int head = getHash(key);
            if (array[head].isEmpty()) {
                return false;
            }
            for (int i = 0; i < array[head].size(); i++) {
                int temp = (int) array[head].get(i);
                if (temp == key) {
                    return true;
                }
            }
            return false;
        }

        public int getHash(int key) {
            return key % base;
        }
    }

    // 重新做
    private class LeetCode705设计哈希集合2 {
        class MyHashSet {

            private final int base = 769;

            private LinkedList[] array;

            public MyHashSet() {
                array = new LinkedList[base];
                for (int i = 0; i < base; i++) {
                    array[i] = new LinkedList();
                }
            }

            public void add(int key) {
                int head = getHash(key);
                for (int i = 0; i < array[head].size(); i++) {
                    int temp = (int) array[head].get(i);
                    if (temp == key) {
                        return;
                    }
                }
                array[head].add(key);
            }

            public void remove(int key) {
                int head = getHash(key);
                int target = -1;
                for (int i = 0; i < array[head].size(); i++) {
                    int temp = (int) array[head].get(i);
                    if (temp == key) {
                        target = i;
                    }
                }
                if (target != -1) {
                    array[head].remove(target);
                }
            }

            public boolean contains(int key) {
                int head = getHash(key);
                if (array[head].isEmpty()) {
                    return false;
                }
                for (int i = 0; i < array[head].size(); i++) {
                    int temp = (int) array[head].get(i);
                    if (temp == key) {
                        return true;
                    }
                }
                return false;
            }

            public int getHash(int key) {
                return key % base;
            }
        }
    }
}
