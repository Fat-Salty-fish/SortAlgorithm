package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/5/17
 */
public class LeetCode421数组中两个数最大的异或值 {
    /**
     * 直接双指针试试
     * 思路有问题 既不能直接找最大值后求异或 也不能双重for循环
     * 只能针对每一位进行运算 或者使用前缀树实现
     * 先使用位运算实现 二刷使用前缀树实现吧
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        int result = 0;
        // mask只是为了取前面的位数
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int temp : nums) {
                set.add(temp & mask);
            }
            int target = result | (1 << i);
            for (Integer test : set) {
                if (set.contains(target ^ test)) {
                    result = target;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 获取数组中最大的异或值
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR2(int[] nums) {
        int result = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int temp : nums) {
                set.add(temp & mask);
            }
            int target = result | (1 << i);
            for (int temp : set) {
                if (set.contains(target ^ temp)) {
                    result = target;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 前缀树节点
     */
    class NodeOfTrie {
        public NodeOfTrie[] map;

        public NodeOfTrie() {
            map = new NodeOfTrie[2];
        }
    }

    /**
     * 前缀树
     */
    class XORTrie {

        /**
         * 这道题里只会是正数 所以只需要后31位
         */
        private int MAX_BIT_SIZE = 30;

        private NodeOfTrie head;

        public XORTrie() {
            head = new NodeOfTrie();
        }

        /**
         * 向前缀树中添加元素
         *
         * @param num
         */
        public void insert(int num) {
            NodeOfTrie node = head;
            for (int i = MAX_BIT_SIZE; i >= 0; i--) {
                int move = (num >> i) & 1;
                NodeOfTrie next = node.map[move] == null ? new NodeOfTrie() : node.map[move];
                node.map[move] = next;
                node = next;
            }
        }

        public int max(int num) {
            NodeOfTrie node = head;
            int result = 0;
            for (int i = MAX_BIT_SIZE; i >= 0; i--) {
                int move = (num >> i) & 1;
                int best = move ^ 1;
                best = node.map[best] == null ? (best ^ 1) : best;
                result = result | ((move ^ best) << i);
                node = node.map[best];
            }
            return result;
        }
    }

    public int findMaximumXOR3(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }
        XORTrie trie = new XORTrie();
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            trie.insert(nums[i-1]);
            result = Math.max(result, trie.max(nums[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int result = new LeetCode421数组中两个数最大的异或值().findMaximumXOR3(nums);
        System.out.println(result);
    }
}
