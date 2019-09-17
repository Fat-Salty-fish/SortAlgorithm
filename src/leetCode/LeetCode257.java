package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/26 19:44
 */
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        path(root,ans,"");
        return ans;
    }

    public void path (TreeNode node ,List<String> ans,String string){
        //当前结点不为空节点时
        if(node != null){
            //先添加数字进去
            String now = string + String.valueOf(node.val);
            //如果是叶子结点 则将这个字符串添加到列表中去
            if(node.left == null && node.right == null){
                ans.add(now);
                return;
            }
            //如果不是叶子结点 则添加一个‘->’符号
            now = now + "->";
            path(node.left,ans,now);
            path(node.right,ans,now);
        }
    }
}
