package leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/29
 */
public class LeetCode179最大数 {

    public String largestNumber(int[] nums) {
        // 对数组根据字典序进行排序
        String addedString = Arrays.stream(Arrays.stream(nums).boxed().toArray()).map(String::valueOf).sorted((x, y) -> (y + x).compareTo(x + y)).collect(Collectors.joining());
        return addedString.charAt(0) == '0' ? "0" : addedString;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};

        List<String> array = Arrays.stream(Arrays.stream(nums).boxed().toArray()).map(String::valueOf).sorted((x, y) -> (y + x).compareTo(x + y)).collect(Collectors.toList());
        System.out.println(array.get(0));
    }
}
