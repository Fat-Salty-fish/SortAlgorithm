package leetCode;

/**
 * @author acer
 * @Date 2019/8/23 16:12
 */
public class LeetCode189 {
    //暴力法 每次向后移动一格
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int previousNum = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = previousNum;
                previousNum = temp;
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = array[i];
        }
    }

    public void rotate3(int[] nums,int k){
        if(nums.length == 1){
            return;
        }
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums,int start,int end){
        int begin = start;
        int over = end;
        while (begin < over){
            int temp = nums[begin];
            nums[begin] = nums[over];
            nums[over] = temp;
            begin++;
            over--;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        new LeetCode189().rotate3(array,3);
        for(int a:array){
            System.out.println(a);
        }
    }
}
