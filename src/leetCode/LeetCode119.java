package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/23 1:35
 */
public class LeetCode119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> array = new ArrayList<>();
        if (rowIndex == 0) {
            List<Integer> ans = new ArrayList<>();
            ans.add(1);
            return ans;
        }
        array.add(new ArrayList<>());
        array.get(0).add(1);
        List<Integer> pointer = null;
        for (int i = 1; i <= rowIndex + 1; i++) {
            List<Integer> temp = new ArrayList<>();
            pointer = array.get(i - 1);
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(pointer.get(j - 1) + pointer.get(j));
            }
            temp.add(1);
            array.add(temp);
        }
        return array.get(rowIndex);
    }

    public List<Integer> single(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex == 0) {
            return ans;
        }
        List<Integer> pointer = ans;
        for (int i = 1; i <= rowIndex ; i++) {
            List<Integer> array = new ArrayList<>();
            array.add(1);
            for (int j = 1; j < i; j++) {
                array.add(pointer.get(j-1)+pointer.get(j));
            }
            array.add(1);
            pointer = array;
        }
        ans = pointer;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode119().single(3));
    }
}
