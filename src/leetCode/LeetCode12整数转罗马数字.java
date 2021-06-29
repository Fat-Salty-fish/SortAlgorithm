package leetCode;

/**
 * @author acer
 * @Date 2019/8/26 21:04
 */
public class LeetCode12整数转罗马数字 {
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

    /**
     * 二刷 数字转换为罗马数字
     * 看懂了一刷时的代码 重新实现一次
     * 其实就是算一遍到底有多少种组合
     * @param num
     * @return
     */
    public String intToRman2(int num){
        int[] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] valuesString = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder builder = new StringBuilder();
        //从大数开始计算 有多少个对应的数字
        for (int i = values.length - 1; i >= 0; i--) {
            // 有几个value[i]
            int times = num / values[i];
            if (times == 0) {
                continue;
            }
            // 添加多少个这个数字
            for (int j = 0; j < times; j++) {
                builder.append(valuesString[i]);
            }
            num -= values[i] * times;
            if (num == 0) {
                break;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        new LeetCode12整数转罗马数字().intToRoman(3);
    }
}
