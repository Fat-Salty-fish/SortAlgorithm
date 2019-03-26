package sortFunctions;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-03-26 11:44
 */
public class MyMergeSort {
    public static void sort(int[] array) {
        int[] temp = new int[array.length];
        sort(array,0,array.length-1,temp);
    }

    private static void sort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid, temp);
            sort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    //left-right表示一个数组的长度
    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        while (j <= right) {
            temp[t++] = array[j++];
        }
        t = 0;
        while (left <= right) {
            array[left++] = temp[t++];
        }
    }
}
