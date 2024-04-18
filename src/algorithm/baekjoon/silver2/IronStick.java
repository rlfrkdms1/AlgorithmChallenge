import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().replaceAll("\\(\\)", "*");
        int result = 0;
        int sticks = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '*') {
                result += sticks;
            }
            if (c == '(') {
                sticks++;
                result++;
            }
            if (c == ')') {
                sticks--;
            }
        }
        System.out.println(result);
    }
}
