import java.util.List;
import java.util.Vector;

public class PrimeNumber {
    public boolean isPrimeNumber (int number)
    {
        for(int i=2;i<number;i++)
        {
            if(number%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public Vector<Integer> caculate(int number)
    {
        Vector<Integer> vector = new Vector<>();
        for(int i=1;i<=number;i++)
        {
            if(isPrimeNumber(i))
            {
                vector.add(i);
            }
        }
        return vector;
    }

    public static void main(String[] args) {
        Vector<Integer> result = new PrimeNumber().caculate(100);
        System.out.println(result);
    }
}
