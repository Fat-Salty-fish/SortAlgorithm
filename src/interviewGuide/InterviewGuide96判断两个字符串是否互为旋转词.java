package interviewGuide;

import java.util.Scanner;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/1
 */
public class InterviewGuide96判断两个字符串是否互为旋转词 {

    /**
     * 判断两个字符串是否为旋转词
     *
     * @param a
     * @param b
     * @return
     */
    public boolean check(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int firstACharFromB = b.indexOf(a.charAt(0));
        // 向前进一步
        firstACharFromB = firstACharFromB == b.length() - 1 ? 0 : firstACharFromB + 1;
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(firstACharFromB)){
                return false;
            }
            firstACharFromB = firstACharFromB == b.length() - 1 ? 0 : firstACharFromB + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine().trim();
        String b = scanner.nextLine().trim();
        boolean result = new InterviewGuide96判断两个字符串是否互为旋转词().check(a,b);
        System.out.println(result);
    }
}
