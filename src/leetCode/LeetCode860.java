package leetCode;

/**
 * @author acer
 * @Date 2019/9/2 0:31
 */
public class LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];
        for (int i = 0; i < money.length; i++) {
            money[i] = 0;
        }
        for (int bill : bills) {
            //如果收到的钱是5块 则一定可以
            if (bill == 5) {
                money[0] = money[0] + 1;
                //是10块则需要给一张5元的
            } else if (bill == 10) {
                if (money[0] > 0) {
                    money[0] = money[0] - 1;
                    money[1] = money[1] + 1;
                } else {
                    return false;
                }
                //是20块的 则需要给3张5元的 或是给1张十元的1张五元的
            } else {
                if (money[1] > 0 && money[0] > 0) {
                    money[1] = money[1]-1;
                    money[0] = money[0]-1;
                    money[2] = money[2]+1;
                }else if (money[0]>=3){
                    money[0] = money[0]-3;
                    money[2] = money[2]+1;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
