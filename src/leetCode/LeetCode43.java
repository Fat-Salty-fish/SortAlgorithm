package leetCode;

/**
 * @author acer
 * @Date 2019/8/6 21:40
 */
public class LeetCode43 {
    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length1 + length2; i++) {
            builder.append('0');
        }
        if (length1 == 0 || length2 == 0) {
            return "";
        }
        for (int i = length1 - 1; i >= 0; i--) {
            int add = 0;
            for (int j = length2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = builder.charAt(i + j + 1) + add + mul % 10 - '0';
                char current = (char) (sum % 10 + '0');
                builder.setCharAt(i + j + 1, current);
                add = mul / 10 + sum / 10;
            }
            builder.setCharAt(i,(char)(add+'0'));
        }
        for(int i = 0; i< length1+length2;i++){
            if(builder.charAt(i)!='0'){
                return builder.substring(i,length1+length2);
            }
        }
        return "0";
    }

    public static void main(String[] args) {
        String a = new String("2");
        String b = new String("3");
        System.out.println(new LeetCode43().multiply(a,b));
    }
}
