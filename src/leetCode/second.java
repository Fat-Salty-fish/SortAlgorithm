package leetCode;

/**
 * @author acer
 * @Date 2019/8/29 19:39
 */

import java.security.Key;
import java.util.*;

public class second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String read = in.nextLine();

        if(read.length() == 0){
            System.out.println("[]");
            return;
        }

        int position = 0;
        for (int i = 0; i < read.length(); i++) {
            if (read.charAt(i) == '\\') {
                position = i;
                break;
            }
        }
        //获取第一个字符串
        String s1 = read.substring(0, position);
        //获取第二个字符串
        String s2 = read.substring(position + 2, read.length());

        if(s2.length() > s1.length()){
            System.out.println("[]");
            return;
        }

        //去除逗号 获取两个数组
        String[] array1 = s1.split(",");
        String[] array2 = s2.split(",");

        StringBuilder ans = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (String a : array1) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        int temp = 0;
        ans.append("[");

        while (temp < array2.length) {
            String curr = array2[temp];
            int num = map.get(curr);
            for(int i = 0;i<num;i++){
                ans.append(curr);
                ans.append(",");
                ans.append(" ");
            }
            map.remove(curr);
            temp++;
        }

        if(map.size() > 0){
            for(Map.Entry<String, Integer> a : map.entrySet()){
                for(int i = 0;i<a.getValue();i++){
                    ans.append(a.getKey());
                    ans.append(",");
                    ans.append(" ");
                }
            }
        }
        ans.delete(ans.length()-2,ans.length());
        ans.append("]");
        System.out.println(ans.toString());
    }
}

