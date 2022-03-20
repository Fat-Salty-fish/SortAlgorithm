package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/19
 */
public class LeetCode423从英文中重建数字 {

    /**
     * 脑经急转弯的题 感觉再也不想做了
     * @param s
     * @return
     */
    public String originalDigits(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] charCount = new int[26];
        for (Character temp : s.toCharArray()) {
            charCount[temp - 'a']++;
        }
        int[] result = new int[10];
        // 统计0的
        while (charCount['z' - 'a'] != 0) {
            charCount['z' - 'a']--;
            charCount['e' - 'a']--;
            charCount['r' - 'a']--;
            charCount['o' - 'a']--;
            result[0]++;
        }
        // 统计2的
        while (charCount['w' - 'a'] != 0) {
            charCount['t' - 'a']--;
            charCount['w' - 'a']--;
            charCount['o' - 'a']--;
            result[2]++;
        }
        // 统计8的
        while (charCount['g' - 'a'] != 0) {
            charCount['e' - 'a']--;
            charCount['i' - 'a']--;
            charCount['g' - 'a']--;
            charCount['h' - 'a']--;
            charCount['t' - 'a']--;
            result[8]++;
        }
        // 统计3的
        while (charCount['h' - 'a'] != 0) {
            charCount['t' - 'a']--;
            charCount['h' - 'a']--;
            charCount['r' - 'a']--;
            charCount['e' - 'a']--;
            charCount['e' - 'a']--;
            result[3]++;
        }
        // 统计4
        while (charCount['u' - 'a'] != 0) {
            charCount['f' - 'a']--;
            charCount['o' - 'a']--;
            charCount['u' - 'a']--;
            charCount['r' - 'a']--;
            result[4]++;
        }
        // 统计6的
        while (charCount['x' - 'a'] != 0) {
            charCount['s' - 'a']--;
            charCount['i' - 'a']--;
            charCount['x' - 'a']--;
            result[6]++;
        }
        // 统计7
        while (charCount['s' - 'a'] != 0) {
            charCount['s' - 'a']--;
            charCount['e' - 'a']--;
            charCount['v' - 'a']--;
            charCount['e' - 'a']--;
            charCount['n' - 'a']--;
            result[7]++;
        }
        // 统计5的
        while (charCount['f' - 'a'] != 0) {
            charCount['f' - 'a']--;
            charCount['i' - 'a']--;
            charCount['v' - 'a']--;
            charCount['e' - 'a']--;
            result[5]++;
        }
        // 统计9的
        result[9] = charCount['i' - 'a'];
        // 统计1的
        result[1] = charCount['o' - 'a'];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            while (result[i] != 0) {
                sb.append(i);
                result[i]--;
            }
        }
        return sb.toString();
    }
}
