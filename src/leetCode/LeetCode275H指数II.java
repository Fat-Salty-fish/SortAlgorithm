package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/5
 */
public class LeetCode275H指数II {

    /**
     * 高引用次数
     * 二分查找 在[0,citations[citationSize-1]]中查询某个数
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int arraySize = citations.length;
        int left = 0;
        int right = arraySize - 1;
        // 本题的核心在于读懂题意, 即在一个升序的数组citations中,找到第一个满足citation[i]>= citations.size-i元素.
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == arraySize - mid) {
                right = mid - 1;
            } else if (citations[mid] > arraySize - mid) {
                right = mid - 1;
            } else if (citations[mid] < arraySize - mid) {
                left = mid + 1;
            }
        }
        return arraySize - left;
    }

    /**
     * 二分查找 左边为蓝色 右边为红色
     * 处于蓝色的条件是什么？
     * arraySize - mid 表示此时 有arraySize-mid个论文的引用次数比citations[mid]相等或者大
     * currentH < arraySize - mid 是蓝色部分 另外的是红色部分
     * @param citations
     * @return
     */
    public int hIndex2(int[] citations) {
        int arraySize = citations.length;
        int left = -1;
        int right = arraySize;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int currentH = citations[mid];
            // arraySize - mid 表示有 arraySize-mid个论文(即论文数量
            if (arraySize - mid > currentH) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return arraySize - left - 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0,1,3,5,6};
        int result = new LeetCode275H指数II().hIndex2(array);
    }
}
