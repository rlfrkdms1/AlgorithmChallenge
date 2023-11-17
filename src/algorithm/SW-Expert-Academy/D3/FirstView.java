import java.util.Scanner;
import java.io.FileInputStream;
 
class FirstView
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int test = 1; test <= 10; test++){
            int T;
            T=Integer.parseInt(sc.nextLine());
            int[] numbers = new int[T];
            String[] number = sc.nextLine().split(" ");
            for(int test_case = 0; test_case < T; test_case++)
            {
                numbers[test_case] = Integer.parseInt(number[test_case]);
            }
            int result = 0;
            for(int i = 2; i < T-2; i++){
                int aroundMax = Math.max(Math.max(numbers[i-1], numbers[i-2]), Math.max(numbers[i+1], numbers[i+2]));
                if(numbers[i] > aroundMax) result+= numbers[i] - aroundMax;
            }
            System.out.println(String.format("#%d %d", test, result));
        }
    }
}
