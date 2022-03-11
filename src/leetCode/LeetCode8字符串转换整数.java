package leetCode;

/**
 * @author acer
 * @Date 2019/8/5 20:35
 */
public class LeetCode8字符串转换整数 {
    public int myAtoi(String str) {
        String trimed = str.trim();
        StringBuilder ans = new StringBuilder();
        if (trimed != null && trimed.length() != 0) {
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

    /**
     * 字符串转换为数字
     * 二刷
     *
     * @param s
     * @return
     */
    public int myAtoi2(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        boolean minus = false;
        int index = 0;
        if (s.charAt(0) == '-') {
            index++;
            minus = true;
        } else if (s.charAt(0) == '+') {
            index++;
        }
        while (index < s.length()) {
            if (s.charAt(index) != '0') {
                break;
            }
            index++;
        }
        if (index >= s.length()) {
            return 0;
        }
        int lastIndex = index;
        while (lastIndex < s.length()) {
            int currentChar = s.charAt(lastIndex) - '0';
            if (!(currentChar >= 0 && currentChar <= 9)) {
                break;
            }
            lastIndex++;
        }
        s = s.substring(index, lastIndex);
        long num = 0;
        int currentIndex = 0;
        while (currentIndex < s.length()) {
            num = num * 10 + (s.charAt(currentIndex) - '0');
            if (!minus) {
                // 如果是正数并超过了int的最大值 则返回最大值
                if (num > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                // 如果是负数并小于了int的最小值 则返回最小值
                if (-num < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            currentIndex++;
        }
        return (int) (minus ? -num : num);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode8字符串转换整数().myAtoi("42"));
    }
}
