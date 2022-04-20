package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/24
 */
public class LeetCode449序列化和反序列化二叉搜索树 {


    /**
     * 二叉搜索树特性 中序遍历后为递增序列
     * 所以只要拿到前序遍历或者后序遍历 排序后就能拿到中序遍历 然后就可以构造二叉搜索树了
     * 这里以后序遍历实践
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            buildString(root, new StringBuilder());
            return builder.toString();

        }

        public void buildString(TreeNode root, StringBuilder builder) {
            if (root == null) {
                return;
            }
            buildString(root.left, builder);
            buildString(root.right, builder);
            builder.append(root.val).append(" ");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) {
                return null;
            }
            String[] split = data.split(" ");
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (String temp : split) {
                deque.add(Integer.parseInt(temp));
            }
            return build(Integer.MAX_VALUE, Integer.MIN_VALUE, deque);
        }

        public TreeNode build(int max, int min, Deque<Integer> arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return null;
            }
            int last = arrayDeque.getLast();
            if (last < min || last > max) {
                return null;
            }
            arrayDeque.removeLast();
            TreeNode root = new TreeNode(last);
            root.right = build(max, last, arrayDeque);
            root.left = build(last, min, arrayDeque);
            return root;
        }
    }

}
