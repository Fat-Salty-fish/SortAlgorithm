package sortFunctions;

/**
 * @Description 归并排序实现 归并：分而治之 将数组进行分解 分解之后进行排序 再逐步合并 最终合并为一个排好序的数组
 * 需要开辟新的地址来保存临时变量 最后放入原先的数组中
 * @auther 李忠杰
 * @create 2019-03-26 10:03
 */
public class MergeSort {
    //进行排序 传入要排序的数组
    public static void sort(int[] array) {
        int[] temp = new int[array.length]; //在排序开始的时候先准备一个数组 避免排序过程中的平凡开辟地址
        sort(array, 0, array.length - 1, temp);
    }

    //进行真正的排序 定义左指针和右指针
    private static void sort(int[] array, int left, int right, int[] temp) {
        //如果左指针小于右指针
        if (left < right) {
            int mid = (right + left) / 2;
            sort(array, left, mid, temp);           //对左序列排序 使左序列有序
            sort(array, mid + 1, right, temp);   //对右序列排序 使右序列有序
            merge(array, left, mid, right, temp);    //将两个有序子数列合并
        }
    }

    //对数组进行合并
    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        //对两个子数组进行比较 会
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
        //将temp数组中的元素拷贝到array中
        while (left <= right) {
            array[left++] = temp[t++];
        }
    }
}
