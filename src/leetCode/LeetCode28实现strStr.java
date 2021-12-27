package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/1
 */
public class LeetCode28实现strStr {

    /**
     * KMP算法实在是不会了
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 暴力解法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "hello";
        String b = "ll";
        int result = new LeetCode28实现strStr().strStr2(a, b);
        System.out.println(result);
    }
}
