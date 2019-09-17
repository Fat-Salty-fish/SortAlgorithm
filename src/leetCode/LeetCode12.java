package leetCode;

/**
 * @author acer
 * @Date 2019/8/26 21:04
 */
public class LeetCode12 {
    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        //定义一个用于输出结果的字符串
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < value.length; i++) {
            //获取最高位
            //a是当前有多少位
            int a = num / value[i];
            if (a == 0) {
                continue;
            }
            for (int j = a; j > 0; j--) {
                builder.append(strings[i]);
            }
            num -= (a*value[i]);
            if(num == 0){
                break;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        new LeetCode12().intToRoman(3);
    }
}
