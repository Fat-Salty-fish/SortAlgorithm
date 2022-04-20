package aimToOfferII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/5
 */
public class AimToOffer38字符串的排列 {

    /**
     * 其实就是全排列
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        char[] array = s.toCharArray();
        Arrays.sort(array);
        List<String> resultList = new ArrayList<>();
        dfs(array, new boolean[s.length()], resultList, new StringBuilder());
        String[] result = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public void dfs(char[] array, boolean[] visited, List<String> result, StringBuilder builder) {
        if (builder.length() == array.length) {
            result.add(builder.toString());
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (visited[i] || (i > 0 && array[i] == array[i - 1] && !visited[i - 1])) {
                continue;
            }
            builder.append(array[i]);
            visited[i] = true;
            dfs(array, visited, result, builder);
            visited[i] = false;
            builder.deleteCharAt(builder.length() - 1);
        }
    }


}
