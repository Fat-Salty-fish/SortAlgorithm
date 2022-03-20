package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/14
 */
public class LeetCode1487保证文件名唯一 {

    /**
     * 感觉set就搞定了
     *
     * @param names
     * @return
     */
    public String[] getFolderNames(String[] names) {
        if (names == null || names.length == 0) {
            return null;
        }
        // 结果字符串数组
        String[] re = new String[names.length];
        // 保存文件出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                re[i] = names[i];
                map.put(names[i], 1);
            } else {
                int count = map.get(names[i]);
                while (map.containsKey(names[i] + "(" + count + ")")) {
                    count++;
                }
                map.put(names[i],map.get(names[i]) + 1);
                map.put(names[i] + "(" + count + ")",1);
                re[i] = names[i] + "(" + count + ")";
            }
        }
        return re;
    }

}
