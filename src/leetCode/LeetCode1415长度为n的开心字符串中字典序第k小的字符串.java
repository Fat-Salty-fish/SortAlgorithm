package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/5/13
 */
public class LeetCode1415长度为n的开心字符串中字典序第k小的字符串 {
    /**
     * 返回长度为n的第k个开心字符串
     * 开心字符串 只有a、b、c三个字符并且 arr[i] != arr[i-1]
     * 其实就是这三个字符的全排列
     * 问题来了 如何构建n个数字下的全排列？
     * @param n
     * @param k
     * @return
     */
    public String getHappyString(int n, int k) {
        List<String> allPath = new ArrayList<>();
        // 以a为开头
        findAll(n, "", allPath);
        if (k > allPath.size()) {
            return "";
        }
        return allPath.get(k - 1);
    }

    public void findAll(int n, String currentPath, List<String> allPath) {
        // 当前字符串已经够长了 就不用了
        if (currentPath.length() == n) {
            allPath.add(currentPath);
            return;
        }
        // 分别在字符串最后添加a b c 构成新的字符串即可
        if (currentPath.length() < 1 || currentPath.charAt(currentPath.length() - 1) != 'a') {
            findAll(n, currentPath + 'a', allPath);
        }
        if (currentPath.length() < 1 || currentPath.charAt(currentPath.length() - 1) != 'b') {
            findAll(n, currentPath + 'b', allPath);
        }
        if (currentPath.length() < 1 || currentPath.charAt(currentPath.length() - 1) != 'c') {
            findAll(n, currentPath + 'c', allPath);
        }
    }

    public static void main(String[] args) {
        int n = 1;
        int k = 3;
        new LeetCode1415长度为n的开心字符串中字典序第k小的字符串().getHappyString(1, 5);
    }
}
