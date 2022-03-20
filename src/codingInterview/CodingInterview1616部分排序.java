package codingInterview;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/11
 */
public class CodingInterview1616部分排序 {

    /**
     * 部分排序
     *
     * @param array
     * @return
     */
    public int[] subSort(int[] array) {
        int min = Integer.MAX_VALUE;
        int biggerThanMinIndex = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > min) {
                biggerThanMinIndex = i;
            } else {
                min = Math.min(min, array[i]);
            }
        }
        if (biggerThanMinIndex == -1) {
            return new int[]{-1, -1};
        }
        int max = Integer.MIN_VALUE;
        int smallerThanMaxIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < max){
                smallerThanMaxIndex = i;
            }else {
                max = Math.max(max,array[i]);
            }
        }
        return new int[]{biggerThanMinIndex,smallerThanMaxIndex};
    }
}
