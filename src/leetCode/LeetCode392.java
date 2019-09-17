package leetCode;

/**
 * @author acer
 * @Date 2019/9/2 0:06
 */
public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0){
            return true;
        }
        //s的指针
        int i = 0;
        //t的指针
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == s.length()) {
                    return true;
                }
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "ahbdgc";
        new LeetCode392().isSubsequence(a,b);
    }
}
