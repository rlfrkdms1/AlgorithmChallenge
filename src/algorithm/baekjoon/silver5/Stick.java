import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Stick {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        List<Integer> sticks = new ArrayList<>();
        sticks.add(64);
        int len = 0;
        while (true) {
            len = 0;
            for (int stick : sticks) {
                len += stick;
            }
            if (len == x) {
                System.out.println(sticks.size());
                return;
            } else {
                int lastStick = sticks.remove(sticks.size() - 1);
                int newStick = lastStick / 2;
                int total = 0;
                for (int stick : sticks) {
                    total += stick;
                }
                total += newStick;
                sticks.add(newStick);
                if (total < x) {
                    sticks.add(newStick);
                }
            }
        }
    }
}
