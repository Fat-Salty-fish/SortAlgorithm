package leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/31
 */
public class LeetCode99恢复二叉搜索树 {

    List<Integer> array = new ArrayList<>();

    /**
     * 首先中序遍历二叉树 保存在一个数组中
     * 然后根据数组寻找有问题的位置
     * 然后再进行交换
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root);
        Integer firstWrongNum = null;
        Integer secondWrongNum = null;
        // 有两种情况 替换的两个节点是连续的或者不连续的
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i + 1)) {
                // 此时必定是连续的
                if (i + 1 == array.size() - 1) {
                    firstWrongNum = array.get(i);
                    secondWrongNum = array.get(i + 1);
                } else {
                    firstWrongNum = array.get(i);
                    // 此时一定是不连续的 需要再向后遍历寻找另一个错误的数字
                    for (int j = i + 2; j < array.size(); j++) {
                        if (array.get(j) < array.get(j - 1)) {
                            secondWrongNum = array.get(j);
                            break;
                        }
                    }
                    if (secondWrongNum == null) {
                        secondWrongNum = array.get(i + 1);
                    }
                }
                break;
            }
        }
        fix(root, firstWrongNum, secondWrongNum);
    }

    /**
     * 中序遍历数组并将结果保存在list中
     *
     * @param root
     */
    public void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        array.add(root.val);
        mid(root.right);
    }

    public void fix(TreeNode root, int firstNum, int secondNum) {
        if (root == null) {
            return;
        }
        fix(root.left, firstNum, secondNum);
        if (root.val == firstNum) {
            root.val = secondNum;
        } else if (root.val == secondNum) {
            root.val = firstNum;
        }
        fix(root.right, firstNum, secondNum);
    }

    /**
     * 二刷 直接改变值
     * 优化了中序遍历
     * 简化寻找两个节点的过程：第一个错误节点为第一次遇到降序时较大的节点 第二个错误节点为最后一次遇到降序时较小的节点
     *
     * @param root
     */
    public void recoverTree2(TreeNode root) {
        TreeNode[] array = new TreeNode[2];
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (pre != null && pre.val > node.val) {
                array[0] = array[0] == null ? pre : array[0];
                array[1] = node;
            }
            pre = node;
            node = node.right;
        }
        int temp = array[0].val;
        array[0].val = array[1].val;
        array[1].val = temp;
    }

    public static void main(String[] args) {
//        TreeNode firstNode = new TreeNode(1);
//        TreeNode secondNode = new TreeNode(2);
//        TreeNode thirdNode = new TreeNode(3);
//        firstNode.left = thirdNode;
//        thirdNode.right = secondNode;
        List<Integer> array = new ArrayList<>();
        int[] arrayNum = new int[]{-33, 321, 55, 71, 146, 231, -13, 399};
        array = Arrays.stream(arrayNum).boxed().collect(Collectors.toList());
//        new LeetCode99恢复二叉搜索树().recoverTree(firstNode);
//        System.out.println(firstNode.val);
    }
}
