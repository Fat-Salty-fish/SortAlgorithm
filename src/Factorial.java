public class Factorial {
    public int caculate(int number)
    {
        if(number==0)
        {
            return 0;
        }
        else if(number == 1)
        {
            return 1;
        }
        else
        {
            return number*caculate(number-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(new Factorial().caculate(5));
    }
}
