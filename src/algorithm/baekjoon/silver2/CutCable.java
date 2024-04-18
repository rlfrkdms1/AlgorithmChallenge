import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int k = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);
        int[] cables = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            if (max < cables[i]) {
                max = cables[i];
            }
        }
        long min = 1;
        while (min <= max) {
            long count = 0;
            long mid = (max + min) / 2;
            for (int cable : cables) {
                count += cable / mid;
            }
            if (count < n) { // 더 작게 잘라야 함
                max = mid - 1;
            } else { // 더 크게 잘라도 됨
                min = mid + 1;
            }
        }
        System.out.println(max);
    }
}
