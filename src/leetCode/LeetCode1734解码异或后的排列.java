package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/5/11
 */
public class LeetCode1734解码异或后的排列 {
    /**
     * 如何解码两个数的异或呢
     * 首先 给了一个数组encoded 那么这个数组的长度+1 就是所求数组的最大值
     * 结果就是[1,encoded.size+1]的一个排列
     * @param encoded
     * @return
     */
    public int[] decode(int[] encoded) {
        int biggest = encoded.length + 1;
        // 从1-最大值的异或
        int total = 0;
        for (int i = 1; i <= biggest; i++) {
            total = total ^ i;
        }
        int besideFirst = 0;
        for (int i = 1; i < encoded.length; i = i + 2) {
            besideFirst = besideFirst ^ encoded[i];
        }
        // 这个就是结果的第一个值
        int firstNum = total ^ besideFirst;
        int[] result = new int[encoded.length+1];
        result[0] = firstNum;
        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = encoded[i] ^ result[i];
        }
        return result;
    }
}
