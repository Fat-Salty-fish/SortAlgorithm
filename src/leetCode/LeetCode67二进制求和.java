package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/12
 */
public class LeetCode67二进制求和 {

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int indexOfA = a.length() - 1;
        int indexOfB = b.length() - 1;
        boolean add = false;
        while (indexOfA >= 0 || indexOfB >= 0) {
            int tempA = 0;
            int tempB = 0;
            if (indexOfA >= 0) {
                tempA = a.charAt(indexOfA) - '0';
                indexOfA--;
            }
            if (indexOfB >= 0) {
                tempB = b.charAt(indexOfB) - '0';
                indexOfB--;
            }
            int temp = tempA + tempB;
            if (add) {
                temp += 1;
            }
            if (temp == 3) {
                builder.insert(0, 1);
                add = true;
            } else if (temp == 2) {
                builder.insert(0, 0);
                add = true;
            } else if (temp == 1) {
                builder.insert(0, 1);
                add = false;
            } else {
                builder.insert(0, 0);
                add = false;
            }
        }
        if (add) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }
}
