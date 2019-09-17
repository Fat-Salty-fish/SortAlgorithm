package leetCode;

/**
 * @author acer
 * @Date 2019/6/12 22:15
 */
public class LeetCode557 {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     * @param s
     * @return
     */
    public String solution(String s){
        char[] array = s.toCharArray();
        //head用来标记单词头
        //tail用来标记单词尾部
        int head = 0;
        int tail = 0;
        int now = 0;
        char temp ;
        while(now < array.length){
            // 当前字符不为空格 则指针指向下一个字符
            while (now < array.length && array[now]!=' ' ){
                ++now;
            }
            tail = now-1;
            System.out.println("此时head为:" + head);
            System.out.println("此时tail为:" + tail);
            //尾部指向now字符的前一个字符
            reverse(array,head,tail);
            if(now != array.length){
                ++now;
                head = now;
            }
        }
        return String.valueOf(array);
    }

    //转换单词的函数
    public void reverse (char[] array,int head,int tail){
        char temp;

        while (head < tail){
            temp = array[tail];
            array[tail] = array[head];
            array[head] = temp;

            ++head;
            --tail;
        }
    }

    public static void main(String[] args) {
        String a = new String("Let's take LeetCode contest");
        System.out.println(a);
        a = new LeetCode557().solution(a);
        System.out.println(a);
    }
}
