package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/1
 */
public class AimToOffer33二叉搜索树的后序遍历序列 {

    /**
     * 检查后序遍历序列是否符合二叉搜索树的要求
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }


    public boolean verify(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int currentNum = postorder[end];
        int firstRight = start;
        while (firstRight < end && postorder[firstRight] < currentNum) {
            firstRight++;
        }
        int check = firstRight;
        while (check < end && postorder[check] > currentNum) {
            check++;
        }
        return check == end && verify(postorder,start,firstRight-1) && verify(postorder,firstRight,end -1);
    }

    public static void main(String[] args) {
        int[] postorder = {1, 2, 5, 10, 6, 9, 4, 3};
        boolean result = new AimToOffer33二叉搜索树的后序遍历序列().verifyPostorder(postorder);
        System.out.println(result);
    }
}
