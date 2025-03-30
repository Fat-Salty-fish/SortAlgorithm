package leetCode;

public class LeetCode415字符串相加 {

    /**
     * 双指针应该就可以解决了
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int indexNum1 = num1.length() - 1, indexNum2 = num2.length() - 1;
        boolean add = false;
        while (indexNum1 >= 0 || indexNum2 >= 0) {
            int temp1 = 0;
            int temp2 = 0;
            if (indexNum1 < 0) {
                temp2 = num2.charAt(indexNum2--) - '0';
            } else if (indexNum2 < 0) {
                temp1 = num1.charAt(indexNum1--) - '0';
            } else {
                temp1 = num1.charAt(indexNum1--) - '0';
                temp2 = num2.charAt(indexNum2--) - '0';
            }
            int current = temp1 + temp2;
            current += add ? 1 : 0;
            add = current / 10 == 1;
            current = current % 10;
            builder.insert(0, current);
        }
        if (add){
            builder.insert(0, '1');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        System.out.println(new LeetCode415字符串相加().addStrings(num1, num2));
    }
}
