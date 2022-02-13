package interviewGuide;

import leetCode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/12
 */
public class InterviewGuide167找到二叉树中符合搜索二叉树条件的最大拓扑结构 {

    Map<TreeNode, Record> map;

    public int GetBSTTopoSize(TreeNode head) {
        map = new HashMap<>();
        return postOrder(head);
    }

    /**
     * 后序遍历树
     * 遍历到当前节点时 计算出当前节点的左子节点和右子节点对当前节点的贡献值 并添加到map中
     * 实际上 整个方法只会再遍历一次整棵树 所以时间复杂度是O(n)
     * @param head
     * @return
     */
    public int postOrder(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int left = postOrder(head.left);
        int right = postOrder(head.right);
        modifyMap(head.left, head.val, true);
        modifyMap(head.right, head.val, false);
        Record leftRecord = map.get(head.left);
        Record rightRecord = map.get(head.right);
        int leftOps = leftRecord == null ? 0 : leftRecord.left + leftRecord.right + 1;
        int rightOps = rightRecord == null ? 0 : rightRecord.left + rightRecord.right + 1;
        map.put(head, new Record(leftOps, rightOps));
        return Math.max(leftOps + rightOps + 1, Math.max(left, right));
    }

    /**
     * 检查是否需要去除当前节点 s用于判断是比value大还是小
     * 因为只需要判断左子树的右边界以及右子树的左边界 在判断右边界时 需要判断当前节点值是否小于value 判断左边界时 需要判断当前节点值是否大于value
     * 如果不符合条件 则将这个节点连同下面的节点都干掉
     *
     * @param head
     * @param value
     * @param s
     * @return
     */
    public int modifyMap(TreeNode head, int value, boolean s) {
        if (head == null || (!map.containsKey(head))) {
            return 0;
        }
        Record record = map.get(head);
        if ((s && head.val > value) || ((!s) && head.val < value)) {
            map.remove(head);
            // 意味着要删除的节点值
            return record.left + record.right + 1;
        } else {
            int modify = modifyMap(s ? head.left : head.right, value, s);
            if (s) {
                record.right = record.right - modify;
            } else {
                record.left = record.left - modify;
            }
            map.put(head, record);
            return modify;
        }
    }

}


class Record {

    /**
     * 左子树贡献值
     */
    public int left;

    /**
     * 右子树贡献值
     */
    public int right;

    public Record(int left, int right) {
        this.left = left;
        this.right = right;
    }

}
