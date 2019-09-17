package aimToOffer.verifySquenceOfBST;

/**
 * @author acer
 * @Date 2019/4/21 10:14
 */

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {
    //二叉搜索树:
    //根节点大于左子节点 小于右子节点
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length<=0) {
            return false;
        }
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    //二叉搜索树后序遍历序列特点：最后一位为整棵树的根节点
    //除去最后一个节点之后 前一段序列的所有数 都比根节点小
    //                 后一段序列的所有数 都比根节点大
    //                 而且这两个序列同样满足这样的条件
    public boolean VerifySquenceOfBST(int[] sequence,int left,int right){
        //相等时说明这个序列只有1个数 则一定是一个二叉搜索树
        //小于的时候说明这个序列没有数 则也一定是一个二叉搜索树
        if(left>=right){
            return true;
        }
        int root = sequence[right];
        int different = left;
        while (different<right && sequence[different]<=root)
            different++;
        for(int i = different;i<right;i++){
            if(sequence[i]<root){
                return false;
            }
        }
        return VerifySquenceOfBST(sequence,left,different-1) && VerifySquenceOfBST(sequence,different,right-1);
    }

    public static void main(String[] args) {
        int[] a  = {4,6,7,5};
        System.out.println(new Solution().VerifySquenceOfBST(a));
    }
}
