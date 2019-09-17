package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/23 0:45
 */
public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows==0){
            return ans ;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        List<Integer> pointer = null;
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            pointer = ans.get(i - 1);
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(pointer.get(j-1)+pointer.get(j));
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
}
