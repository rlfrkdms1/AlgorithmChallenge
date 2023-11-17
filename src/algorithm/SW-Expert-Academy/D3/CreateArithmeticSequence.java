import java.util.Scanner;
import java.io.FileInputStream;
 
class CreateArithmeticSequence
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            double x = Math.min(Math.abs(2*b-a-c),Math.abs(0.5*(a+c-2*b)));
            System.out.printf("#%d %.1f\n",test_case,x);
        }
    }
}
