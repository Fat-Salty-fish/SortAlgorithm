package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/1/27
 */
public class LeetCode38外观数列 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String word = countAndSay(n-1);
        return SayString(word);
    }


    /**
     * 描述这个字符串
     */
    public String SayString(String str) {
        if (str.isEmpty()) {
            return "";
        }
        int count = 0;
        char prep = 'a';
        StringBuilder builder = new StringBuilder();
        for (char temp : str.toCharArray()) {
            if (temp == prep) {
                count++;
            } else {
                if (prep == 'a') {
                    prep = temp;
                    count = 1;
                } else {
                    builder.append(count);
                    builder.append(prep);
                    prep = temp;
                    count = 1;
                }
            }
        }
        builder.append(count);
        builder.append(prep);
        return builder.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        String result = new LeetCode38外观数列().countAndSay(n);
        System.out.printf(result);
    }
}
