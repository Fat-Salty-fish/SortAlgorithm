package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author acer
 * @Date 2019/8/11 23:18
 */
public class LeetCode146 {

    class DNode {
        public int key, val;
        public DNode next, prev;

        public DNode(int k, int v) {
            key = k;
            val = v;
        }
    }

    class DList {
        public DNode head, tail;
        public int size;

        public DList() {
            head = new DNode(0, 0);
            tail = new DNode(0, 0);
            tail.prev = head;
            head.next = tail;
            size = 0;
        }

        //在链表头部添加节点x
        public void addFirst(DNode x) {
            DNode temp = head.next;
            head.next = x;
            temp.prev = x;
            x.next = temp;
            x.prev = head;
            size++;
        }

        //删除链表中的节点
        public void delete(DNode x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        //删除链表中的最后一个节点 并返回这个节点
        public DNode deleteLast() {
            if (tail.prev == head) {
                return null;
            }
            DNode lastNode = tail.prev;
            delete(lastNode);
            return lastNode;
        }

        //返回链表的长度
        public int size() {
            return size;
        }
    }

    public class LRUCache {
        public Map<Integer, DNode> cache;
        public DList list;
        public int capacity;

        public LRUCache(int capacity) {
            cache = new HashMap<>();
            list = new DList();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            DNode node = cache.get(key);
            put(key,node.val);
            return node.val;
        }

        public void put(int key, int value) {
            //如果缓存内有这个数据 则删除掉原来的数据并添加新的数据
            DNode current = new DNode(key,value);
            if(cache.containsKey(key)){
                list.delete(cache.get(key));
                list.addFirst(current);
                cache.put(key,current);
            }else {
                if(list.size == capacity){
                    DNode node = list.deleteLast();
                    cache.remove(node.key);
                }
                list.addFirst(current);
                cache.put(key,current);
            }
        }
    }
}
