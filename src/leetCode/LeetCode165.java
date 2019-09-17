package leetCode;

/**
 * @author acer
 * @Date 2019/8/29 21:23
 */
public class LeetCode165 {
    public int compareVersion(String version1, String version2) {
        //分别设置成两个数组
        int p1 = 0;
        int p2 = 0;
        int num1 = 0;
        int num2 = 0;
        while (p1 < version1.length() || p2 < version2.length()) {
            while (p1 < version1.length() && version1.charAt(p1) != '.') {
                num1 = num1 * 10 + version1.charAt(p1) - '0';
                p1++;
            }
            while (p2 < version2.length() && version2.charAt(p2) != '.') {
                num2 = num2 * 10 + version2.charAt(p2) - '0';
                p2++;
            }
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            } else {
                num1 = 0;
                num2 = 0;
                p1++;
                p2++;
            }
        }
        return 0;
    }
}
