package leetCode;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author acer
 * @Date 2019/8/26 22:25
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        Map<String,List> map = new HashMap<>();
        for(String s:strs){
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list:map.values()){
            ans.add(list);
        }
        return ans;
    }
}
