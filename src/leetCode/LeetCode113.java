package leetCode;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/29 19:07
 */
public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        find(ans, new ArrayList<>(), root, sum);
        return ans;
    }

    public void find(List<List<Integer>> ans, List<Integer> one, TreeNode node, int sum) {
        //不为空时进行操作
        if (node == null) {
            return;
        }
        one.add(node.val);
        if(node.left == null && node.right == null && sum-node.val == 0){
            ans.add(new ArrayList<>(one));
        }
        find(ans,one,node.left,sum-node.val);
        find(ans,one,node.right,sum-node.val);
        one.remove(one.size()-1);
    }
}
