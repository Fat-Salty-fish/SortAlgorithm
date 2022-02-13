package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/13
 */
public class LeetCode556下一个更大元素III {

    /**
     * 从后往前 找到第一个降序的数 然后再向后找 找到比这个数大的最小的值 交换后 排序这段数字
     *
     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {
        char[] charArray = ("" + n).toCharArray();
        int length = charArray.length;
        int tempIndex = length - 2;
        while (tempIndex >= 0 && charArray[tempIndex] >= charArray[tempIndex + 1]) {
            tempIndex--;
        }
        if (tempIndex < 0) {
            return -1;
        }
        int j = length - 1;
        while (j >= 0 && charArray[j] <= charArray[tempIndex]) {
            j--;
        }
        swap(charArray, tempIndex, j);
        reverse(charArray, tempIndex + 1);
        try {
            return Integer.parseInt(String.valueOf(charArray));
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 交换两个位置的值
     *
     * @param array
     * @param left
     * @param right
     */
    public void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public void reverse(char[] array, int start) {
        int j = array.length - 1;
        int i = start;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

}
