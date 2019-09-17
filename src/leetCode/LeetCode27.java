package leetCode;

/**
 * @author acer
 * @Date 2019/5/2 16:47
 */


/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        //头指针
        int head = 0;
        //尾指针
        int tail = nums.length-1;
        while (head< nums.length && tail>=0 && head< tail){
            //从头往后找 找到是val的值
            while (nums[head]!=val&&head<tail){
                ++head;
            }
            //从后往前找 找到不是val的值
            while (nums[tail]==val&&head<tail){
                --tail;
            }
            //交换
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
        }
        int length = 0;
        while (length<nums.length&& nums[length]!=val ){
            ++length;
        }
        return length;
    }

    public static void main(String[] args) {
        int result = new LeetCode27().removeElement(new int[]{2},3);

    }
}
