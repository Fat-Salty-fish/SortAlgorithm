package leetCode;

/**
 * @author acer
 * @Date 2019/8/5 20:35
 */
public class LeetCode8 {
    public int myAtoi(String str) {
        String trimed = str.trim();
        StringBuilder ans = new StringBuilder();
        if (trimed != null && trimed.length()!=0 ) {
            char current = trimed.charAt(0);
            //当它是数字或者是加减号时
            if ((current >= '0' && current <= '9') || current == '-' || current == '+') {
                ans.append(current);
                for (int i = 1; i < trimed.length(); i++) {
                    char temp = trimed.charAt(i);
                    if (!(temp >= '0' && temp <= '9')) {
                        break;
                    }
                    ans.append(temp);
                }
            }
        }
        if (ans.length() == 0 || ans.toString().equals("+") || ans.toString().equals("-")) {
            return 0;
        }
        int answer = 0;
        try {
            answer = Integer.valueOf(ans.toString());
        } catch (Exception e) {
            if (ans.charAt(0) == '-') {
                answer = Integer.MIN_VALUE;
            } else {
                answer = Integer.MAX_VALUE;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode8().myAtoi("+"));
    }
}
