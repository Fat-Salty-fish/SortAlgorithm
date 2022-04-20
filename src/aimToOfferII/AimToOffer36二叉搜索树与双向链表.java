package aimToOfferII;

import leetCode.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/4
 */
public class AimToOffer36二叉搜索树与双向链表 {


    /**
     * 可以先中序遍历一次
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size(); i++) {
            Node current = list.get(i);
            current.left = i == 0 ? list.get(list.size() - 1) : list.get(i - 1);
            current.right = i == list.size() - 1 ? list.get(0) : list.get(i + 1);
        }
        return list.get(0);
    }

    public void inOrder(Node root, List<Node> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    /**
     * 前一个节点
     */
    Node pre;

    /**
     * 记录一下头节点
     */
    Node head;


    /**
     * 一次遍历即可
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }

    public static void main(String[] args) {

    }
}
