public class NumberOfBit {

    public int bitsOfNumber(int number,int bit)
    {
        int result = number/10;
        if(number == 0 )
        {
            return 0;
        }
        else if (result==0)
        {
            return (bit+1);
        }
        else
        {
            return bitsOfNumber(result,bit+1);
        }
    }

    public  void printEveryBit(int number,int bit)
    {
        for(int i=0;i<bit;i++)
        {
            System.out.println(number%10);
            number=number/10;
        };
    }

    public static void main(String[] args) {
        int number =123;
        int bit = new NumberOfBit().bitsOfNumber(number,0);
        System.out.println("这个数的位数是"+bit);
        new NumberOfBit().printEveryBit(number,bit);
    }
}
