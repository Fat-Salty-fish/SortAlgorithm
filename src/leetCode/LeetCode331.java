package leetCode;

/**
 * @author acer
 * @Date 2019/9/3 15:04
 */
public class LeetCode331 {
    public boolean isValidSerialization(String preorder) {
        String[] array = preorder.split(",");
        if (array[0].equals("#") && array.length == 1) {
            return true;
        }
        if (array[0].equals("#") || array.length % 2 == 0) {
            return false;
        }
        //根节点的入度比其他节点多1 所以先初始化为1
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            //读取每个节点时度应该都减一
            count--;
            if(count<0)
                return false;
            //读取到#不加也不减 则读取到非#时应该加2
            if(!array[i].equals("#"))
                count+=2;
        }
        return count == 0;
    }
}
