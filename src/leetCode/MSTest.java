package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/6
 */
public class MSTest {

    public int mod = 100000007;

    public int numWays(String s) {
        if (s == null || s.length() < 3) {
            return 0;
        }
        int stringLength = s.length();
        int[] mem = new int[stringLength + 1];
        for (int i = 1; i <= stringLength; i++) {
            mem[i] = mem[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
        }
        int result = 0;
        for (int i = 1; i < stringLength; i++) {
            for (int j = i + 1; j < stringLength; j++) {
                int leftStringNum = mem[i];
                int midStringNum = mem[j] - mem[i];
                int rightStringNum = mem[stringLength] - mem[j];
                if (leftStringNum == midStringNum && leftStringNum == rightStringNum) {
                    result++;
                    result %= mod;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        String a = "10101";
        int result = new MSTest().numWays(a);
        System.out.println(result);
    }
}
