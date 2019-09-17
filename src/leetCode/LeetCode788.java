package leetCode;

import java.sql.PseudoColumnUsage;

/**
 * @author acer
 * @Date 2019/5/3 10:17
 */
public class LeetCode788 {
    //判断0-N有多少个“好数” 好数定义：数中每一位旋转180°之后变成的数组与原来不同并且也是有效的数组即为好数
    //1，0，8旋转之后依然是相同的
    //2，5可以相互转换 6，9可以相互转换
    public int rotatedDigits(int N) {
        if (N > 10000) {
            throw new IllegalArgumentException();
        }
        char[] array = null;
        int num = 0;
        for (int i = 1; i <= N; i++) {
            array = Integer.toString(i).toCharArray();
            StringBuilder builder = new StringBuilder();
            int has = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == '2') {
                    array[j] = '5';
                } else if (array[j] == '5') {
                    array[j] = '2';
                } else if (array[j] == '6') {
                    array[j] = '9';
                } else if (array[j] == '9') {
                    array[j] = '6';
                } else if (array[j] == '1' || array[j] == '0' || array[j] == '8') {

                } else {
                    //除了上述数字之外 其余数字旋转之后肯定不同
                    has = 1;
                    break;
                }
                builder.append(array[j]);
            }
            if (has == 0 && !builder.toString().equals(Integer.toString(i))) {
                ++num;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode788().rotatedDigits(10));
    }
}
