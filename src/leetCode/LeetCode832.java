package leetCode;


/**
 * @author acer
 * @Date 2019/8/22 16:36
 */
public class LeetCode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) {
            return A;
        }
        if(A[0].length==1){
            for(int i = 0;i<A.length;i++){
                A[i][0] = A[i][0] ^1;
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length / 2 || j == A[i].length / 2 - 1; j++) {
                int left = j;
                int right = A[0].length - 1 - j;
                int temp = A[i][left];
                //先进行交换
                A[i][left] = A[i][right];
                A[i][right] = temp;
                //再进行反转
                A[i][left] = (A[i][left] ^ 1);
                A[i][right] = (A[i][right] ^ 1);
                //在奇数时并且当前左指针在中心位置的左边
                if (j == A[i].length / 2 - 1 && A[i].length % 2 == 1) {
                    A[i][left + 1] = (A[i][left + 1] ^ 1);
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        new LeetCode832().flipAndInvertImage(new int[][]{{1}});
    }
}
