package interviewGuide;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/4
 */
public class InterviewGuide123字符串的转换路径问题 {

    int currentLength = -1;

    List<List<String>> result;

    /**
     * 从from字符串转换为to字符串 每次只能修改一个字符 并且中间字符串必须经由array里的字符串
     *
     * @param from
     * @param to
     * @param array
     * @return
     */
    public List<List<String>> getChangePath(String from, String to, String[] array) {
        result = new ArrayList<>();
        Set<String> strSet = new HashSet<>(Arrays.asList(array));
        dfs(from, to, new HashSet<>(), strSet, new ArrayList<>());
        return result;
    }

    /**
     * 遍历
     *
     * @param currentStr
     * @param target
     * @param visitedIndex
     * @param strArray
     * @param path
     */
    public void dfs(String currentStr, String target, Set<Integer> visitedIndex, Set<String> strArray, List<String> path) {
        if (currentStr.equals(target)) {
            if (currentLength == -1) {
                result.add(new ArrayList<>(path));
                currentLength = path.size();
            } else if (path.size() < currentLength) {
                result = new ArrayList<>();
                result.add(new ArrayList<>(path));
                currentLength = path.size();
            } else if (path.size() == currentLength) {
                result.add(new ArrayList<>(path));
            }
        }
        for (int i = 0; i < currentStr.length(); i++) {
            if (visitedIndex.contains(i)) {
                continue;
            }
            if (currentStr.charAt(i) == target.charAt(i)) {
                visitedIndex.add(i);
                continue;
            }
            char[] change = currentStr.toCharArray();
            change[i] = target.charAt(i);
            String strChange = new String(change);
            if (strArray.contains(strChange)) {
                visitedIndex.add(i);
                path.add(strChange);
                dfs(strChange, target, visitedIndex, strArray, path);
                visitedIndex.remove(i);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String from = "abc";
        String to = "cab";
        String[] array = {"cab", "acc", "cbc", "ccc", "cac", "cbb", "aab", "abb"};
        List<List<String>> result = new InterviewGuide123字符串的转换路径问题().getChangePath(from, to, array);
        System.out.println(result.get(0).size());
    }
}
