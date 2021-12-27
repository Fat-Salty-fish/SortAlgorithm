package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/2
 */
public class LeetCode536从字符串构建二叉树 {

    /**
     * 尝试递归
     *
     * @param s
     * @return
     */
    public TreeNode str2tree(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        if (s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')') {
            s = s.substring(1, s.length() - 1);
        }
        if (s.length() == 1) {
            return new TreeNode(s.charAt(0) - '0');
        }
        TreeNode currentNode = null;
        int myIndex = 0;
        for (; myIndex < s.length(); myIndex++) {
            if (s.charAt(myIndex) == '(') {
                currentNode = new TreeNode(Integer.parseInt(s.substring(0, myIndex)));
                break;
            }else if (myIndex == s.length()-1){
                return new TreeNode(Integer.parseInt(s));
            }
        }
        String leftStr = s.substring(myIndex);
        if ("".equals(leftStr)) {
            return currentNode;
        }
        // 计算左子树的最后一个index
        int left = 0;
        int leftNum = 0;
        for (; left < leftStr.length(); left++) {
            if (leftStr.charAt(left) == '(') {
                leftNum++;
            } else if (leftStr.charAt(left) == ')') {
                leftNum--;
                if (leftNum == 0) {
                    break;
                }
            }
        }
        currentNode.left = str2tree(leftStr.substring(0, left + 1));
        currentNode.right = str2tree(leftStr.substring(left + 1));
        return currentNode;
    }


    public static void main(String[] args) {
        String a = "-1";
        TreeNode result = new LeetCode536从字符串构建二叉树().str2tree(a);
        System.out.println(result.val);
    }
}
