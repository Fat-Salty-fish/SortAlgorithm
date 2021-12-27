package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/4
 */
public class LeetCode222完全二叉树的节点个数 {

    /**
     * 求该树的节点个数
     * 这个怎么用二分搜索解决？
     * 这个只需要一次遍历
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 使用完全二叉树的特性来解决
     * 先获取完全二叉树的高度 然后即可得知节点个数的范围
     * 然后通过二分查找来查询此节点是否存在
     * 完全二叉树 从上到下 每一层的节点数为 2的(i-1)次方个
     * 总共有的节点数为 2的(h+1)次方-1个(h为高度 计算高度时从0开始) (等比数列求和)
     *
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 高度
        int height = -1;
        TreeNode leftNode = root;
        while (leftNode != null) {
            leftNode = leftNode.left;
            height++;
        }
        // 整棵树的节点数的范围
        // 假设最后一层只有一个节点 min = 2的h次方(上一层的总节点数为2的h次方-1 +1即可)
        int treeNumMin = 1 << height;

        // max = 2的(h+1)次方-1
        int treeNumMax = (1 << (height + 1)) - 1;
        // 左边界
        int left = treeNumMin;
        // 右边界
        int right = treeNumMax + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 说明没找到边界
            if (checkExistNode(root, mid, height)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }

    /**
     * 通过二进制来判断是否存在此节点
     * 假设节点位置的值为k
     * 需要先舍弃掉height位的数
     *
     * @param root   根节点
     * @param target 目标位置
     * @param height 整棵树的高度
     * @return
     */
    public boolean checkExistNode(TreeNode root, int target, int height) {
        TreeNode currentNode = root;
        int singleBit = 1 << height - 1;
        while (currentNode != null && singleBit > 0) {
            int and = singleBit & target;
            if (and == 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
            singleBit = singleBit >> 1;
        }
        return currentNode != null;
    }


    public static void main(String[] args) {
        int target = 3;
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        int check = new LeetCode222完全二叉树的节点个数().countNodes2(head);
        System.out.println("结果为" + check);
    }
}
