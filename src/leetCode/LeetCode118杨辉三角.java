package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/23 0:45
 */
public class LeetCode118杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
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
                temp.add(pointer.get(j - 1) + pointer.get(j));
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }

    /**
     * 微软模拟面试 杨辉三角
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(1);
        result.add(firstRow);
        if (numRows == 1) {
            return result;
        }
        result.add(secondRow);
        if (numRows == 2) {
            return result;
        }
        List<Integer> currentList = secondRow;
        for (int i = 3; i <= numRows; i++) {
            currentList = build(i, currentList);
            result.add(currentList);
        }
        return result;
    }

    /**
     * numRow一定大等于3
     *
     * @param numRows
     * @param lastList
     * @return
     */
    public List<Integer> build(int numRows, List<Integer> lastList) {
        List<Integer> result = new ArrayList<>(numRows);
        result.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            result.add(lastList.get(i - 1) + lastList.get(i));
        }
        result.add(1);
        return result;
    }


}
