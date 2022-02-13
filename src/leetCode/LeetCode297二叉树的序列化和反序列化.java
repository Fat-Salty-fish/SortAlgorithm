package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/1
 */
public class LeetCode297二叉树的序列化和反序列化 {


    public static class Codec {

        /**
         * 用左右括号进行编码
         *
         * @param root
         * @return
         */
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            builder.append(root.val);
            return builder.append("(").append(serialize(root.left)).append(")").append("(").append(serialize(root.right)).append(")").toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            // 第一步 先找到这个节点的value值
            int index = 0;
            while (data.charAt(index) != '(' && data.charAt(index) != ')') {
                index++;
            }
            int tempNum = Integer.parseInt(data.substring(0, index));
            TreeNode currentNode = new TreeNode(tempNum);
            // 只有查找左子树的时候会重复遍历？所以时间复杂度还可以
            // 查找属于左子树的字符串
            Deque<Character> symbolStack = new ArrayDeque<>();
            symbolStack.push(data.charAt(index++));
            int leftChildStart = index;
            int leftChildEnd = leftChildStart;
            while (index < data.length()) {
                Character currentChar = data.charAt(index);
                if (currentChar == '(') {
                    symbolStack.push(currentChar);
                } else if (currentChar == ')') {
                    symbolStack.pop();
                    if (symbolStack.isEmpty()) {
                        leftChildEnd = index;
                        index++;
                        break;
                    }
                }
                index++;
            }
            currentNode.left = deserialize(data.substring(leftChildStart, leftChildEnd));

            // 查找属于右子树的字符串
            symbolStack.push(data.charAt(index++));
            int rightChildStart = index;
            currentNode.right = deserialize(data.substring(rightChildStart, data.length() - 1));
            return currentNode;
        }
    }

    public static class Codec2 {

        /**
         * 用dfs先序遍历构造
         * 若节点为空 则设置返回"X"
         *
         * @param root
         * @return
         */
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "X";
            }
            StringBuilder builder = new StringBuilder();
            builder.append(root.val);
            return builder.append(",").append(serialize(root.left)).append(",").append(serialize(root.right)).toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // 用逗号进行分组
            String[] array = data.split(",");
            List<String> list = new LinkedList<String>(Arrays.asList(array));
            return deserialize(list);
        }

        public TreeNode deserialize(List<String> nodeStrList){
            if (nodeStrList.get(0).equals("X")){
                nodeStrList.remove(0);
                return null;
            }
            int currentNodeVal = Integer.parseInt(nodeStrList.remove(0));
            TreeNode root = new TreeNode(currentNodeVal);
            root.left = deserialize(nodeStrList);
            root.right = deserialize(nodeStrList);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        Codec2 codec = new Codec2();
        String str = codec.serialize(treeNode);
//        String str = "4(-7()())(-3(-9(9(6(0()(-1()()))(6(-4()())()))())(-7(-6(5()())())(-6(9(-2()())())())))(-3(-4()())()))";
        System.out.println(str);
        TreeNode result = codec.deserialize(str);
        System.out.println(result.val);
    }
}
