package aimToOfferII;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/4
 */
public class AimToOffer37序列化二叉树 {

    public class Codec {

        String str = "n";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            serialize(root, builder);
            return builder.toString();
        }

        public void serialize(TreeNode root, StringBuilder builder) {
            if (root == null) {
                builder.append(str).append(",");
                return;
            }
            builder.append(root.val).append(",");
            serialize(root.left, builder);
            serialize(root.right, builder);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) {
                return null;
            }
            String[] strings = data.split(",");
            List<String> nodeValues = new ArrayList<>(Arrays.asList(strings));
            return deserialize(nodeValues);
        }

        public TreeNode deserialize(List<String> strings) {
            if (strings.isEmpty()) {
                return null;
            }
            if (str.equals((strings.get(0)))) {
                strings.remove(0);
                return null;
            }
            int currentValue = Integer.parseInt(strings.remove(0));
            TreeNode root = new TreeNode(currentValue);
            root.left = deserialize(strings);
            root.right = deserialize(strings);
            return root;
        }
    }
}
