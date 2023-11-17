import java.util.Scanner;
import java.io.FileInputStream;
 
class StringString
{
    public static void main(String args[]) throws Exception
    {
     
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String result = "Yes";
            int length = sc.nextInt();
            sc.nextLine();
            String input = sc.nextLine();
            if(length == 1 || length % 2 != 0) result = "No";
            else {
                String target = input.substring(length/2, length);
                for(int i = 0; i < length/2; i++){
                    if(target.charAt(i) != input.charAt(i)){
                        result = "No";
                        break;
                    }
                }
            }
            System.out.printf("#%d %s\n", test_case, result);
             
        }
    }
}
