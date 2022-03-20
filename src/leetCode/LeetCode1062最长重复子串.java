package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/20
 */
public class LeetCode1062最长重复子串 {


    String original;

    /**
     * 最长重复子串
     * 二分查找+滑动窗口+哈希表
     * 用二分查找找到有重复子串的最大长度
     * 用滑动窗口和哈希表来验证是否有当前长度下的重复子串
     *
     * @param s
     * @return
     */
    public int longestRepeatingSubstring(String s) {
        original = s;
        return binarySearch(s.length());
    }

    /**
     * 二分查找
     * 如何二分查找？
     *
     * @param length
     * @return
     */
    public int binarySearch(int length) {
        int left = 1;
        int right = length;
        // 搜索区间为[left,right] left-1为最长重复子串的长度
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 不存在
            if (haveRepeatSubString(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    /**
     * 判断目标长度下是否有重复子串
     * 如果没有重复子串 则返回-1
     * 滑动窗口+哈希表
     *
     * @param length
     * @return
     */
    public int haveRepeatSubString(int length) {
        Set<String> set = new HashSet<>();
        int left = 0;
        int right = left + length - 1;
        while (right < original.length()) {
            String temp = original.substring(left, right + 1);
            if (set.contains(temp)) {
                return 1;
            }
            set.add(temp);
            left++;
            right++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "abbaba";
        int result = new LeetCode1062最长重复子串().longestRepeatingSubstring(a);
        System.out.println(result);
    }
}
