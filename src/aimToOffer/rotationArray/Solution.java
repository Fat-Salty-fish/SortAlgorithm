package aimToOffer.rotationArray;

/**
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 *
 * @author acer
 * @Date 2019/4/6 20:09
 */
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        int low = 0;
        int high = array.length - 1;
        //整个过程即为寻找两个子数组的分界线 采用了二分查找的方法
        //通过两个指针进行寻找 一个指向数组头 一个指向数组尾
        //两段数组 前数组的所有元素都大于后数组的元素
        //如果中位的元素大于头元素 则中位处在前数组中 让低位元素移动到mid的位置的右边一位
        //否则判断中位的元素是否与末尾元素相同（因为会有相同元素）让高位元素移动到high的位置的左边一位
        //否则 此时中位处于后数组中 将末尾元素移动
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
                //此时判断是否为相同的元素
            } else if (array[mid] == array[high]){
                high = high -1;
            }else {
                high = mid;
            }
        }
        return array[low];
    }
}
