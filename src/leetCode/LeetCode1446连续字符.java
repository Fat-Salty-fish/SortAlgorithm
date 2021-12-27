package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/2
 */
public class LeetCode1446连续字符 {


    public int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0;
        int result = 1;
        int current = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(start)) {
                current++;
            } else {
                result = Math.max(result,current);
                current = 1;
                start = i;
            }
        }
        result = Math.max(result,current);
        return result;
    }
}
