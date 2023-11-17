import java.util.Scanner;
import java.io.FileInputStream;
 
class AddOnlyOdd
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String line = sc.nextLine();
            String[] lines = line.split(" ");
            int[] numbers = new int[lines.length];
            for(int i = 0; i < lines.length; i++){
                numbers[i] = Integer.parseInt(lines[i]);
            }
            int sum = 0;
            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] % 2 != 0) {
                    sum += numbers[i];
                }
            }
            System.out.println(String.format( "#%d %d", test_case, sum));
        }
    }
}
