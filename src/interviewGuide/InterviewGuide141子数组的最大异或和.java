package interviewGuide;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/9
 */
public class InterviewGuide141子数组的最大异或和 {

    /**
     * 最大的异或和
     *
     * @param array
     * @return
     */
    public int maxXOR(int[] array) {
        int[] prefix = new int[array.length];
        for (int i = 0; i < prefix.length; i++) {
            prefix[i] = i == 0 ? array[i] : array[i] ^ prefix[i - 1];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prefix.length; i++) {
            for (int j = i; j >= 0; j--) {
                max = Math.max(max, (j == 0 ? 0 : prefix[j - 1]) ^ prefix[i]);
            }
        }
        return max;
    }

    /**
     * 类似于前缀树的解法
     *
     * @param array
     * @return
     */
    public int maxXOR2(int[] array) {
        XORTrie trie = new XORTrie();
        trie.insert(0);
        int result = 0;
        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
            result = Math.max(result, trie.maxXOR(xor));
            trie.insert(xor);
        }
        return result;
    }

    /**
     * 异或前缀树
     */
    class XORTrie {
        private XORTrieNode head;

        public XORTrie() {
            head = new XORTrieNode();
        }

        /**
         * 向前缀树中添加数字
         *
         * @param num
         * @return
         */
        public void insert(int num) {
            XORTrieNode node = head;
            for (int move = 31; move >= 0; move--) {
                int moveNum = (num >> move) & 1;
                XORTrieNode next = node.map[moveNum];
                if (next == null) {
                    next = new XORTrieNode();
                    node.map[moveNum] = next;
                }
                node = next;
            }
        }

        /**
         * 给定一个num 判断一棵树里的所有树 能和这个树的异或的最大值
         *
         * @param num
         * @return
         */
        public int maxXOR(int num) {
            // 先判断最高位 如果当前数是正数 则最高位节点选择为0 如果当前数是负数 则最高位节点选择为1
            int result = 0;
            XORTrieNode node = head;
            for (int move = 31; move >= 0; move--) {
                int moveNum = (num >> move) & 1;
                int best = move == 31 ? moveNum : (moveNum ^ 1);
                best = node.map[best] != null ? best : (best ^ 1);
                result = result | ((moveNum ^ best) << move);
                node = node.map[best];
            }
            return result;
        }
    }

    class XORTrieNode {
        /**
         * 前缀树节点map 因为只会有两个路径0和1 所以size 只为2
         */
        public XORTrieNode[] map;

        public XORTrieNode() {
            map = new XORTrieNode[2];
        }
    }

    public static void main(String[] args) {
        int[] array = {3, -28, -29, 2};
        int result = new InterviewGuide141子数组的最大异或和().maxXOR2(array);
        System.out.println(result);
    }
}
