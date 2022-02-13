package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/1
 */
public class LeetCode273整数转换英文表示 {

    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};


    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder builder = new StringBuilder();
        for (int unit = 1000000000, time = 3; time >= 0; time--, unit /= 1000) {
            int currentNum = num / unit;
            if (currentNum != 0) {
                num -= currentNum * unit;
                String tempStr = buildHundred(currentNum);
                builder.append(tempStr).append(thousands[time]).append(" ");
            }
        }
        return builder.toString().trim();
    }

    /**
     * 构造百位数
     * num的范围是0-100
     *
     * @param num
     */
    public String buildHundred(int num) {
        if (num == 0) {
            return "";
        }
        StringBuilder buildString = new StringBuilder();
        if (num >= 100) {
            int temp = num / 100;
            buildString.append(singles[temp]).append(" Hundred ");
            num -= temp * 100;
        }
        if (num >= 20) {
            int temp = num / 10;
            buildString.append(tens[temp]).append(" ");
            num -= temp * 10;
        }
        if (num >= 10 && num < 20) {
            int temp = num % 10;
            buildString.append(teens[temp]).append(" ");
            return buildString.toString();
        }
        if (num > 0){
            buildString.append(singles[num]).append(" ");
        }
        return buildString.toString();
    }

    public static void main(String[] args) {
        int test = 123;
        String result = new LeetCode273整数转换英文表示().numberToWords(test);
        System.out.println(result);
    }
}
