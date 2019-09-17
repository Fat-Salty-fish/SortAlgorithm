package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/29 18:29
 */
public class LeetCode109 {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        return build(array,0,array.length);
    }

    public TreeNode build(Integer[] array,int start,int end){
        TreeNode node = null;
        //证明有节点是属于这一棵树的
        if(end - start > 0)
        {
            int temp = (start+end)/2;
            node = new TreeNode(array[temp]);
            node.left = build(array,start,temp);
            node.right = build(array,temp+1,end);
        }
        return node;
    }
}
