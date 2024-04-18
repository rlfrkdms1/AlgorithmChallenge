import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        map = new boolean[n][m];
        for(int i = 0; i < n; i ++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < line.length; j++) {
                if(line[j].equals("W")) map[i][j] = true;
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int result = makeChess(i, j);
                if (result < answer) {
                    answer = result;
                }
            }
        }
        System.out.println(answer);
    }

    public static int makeChess(int x, int y) {
        int count = 0;

        boolean pre = map[x][y];
        for (int i = x; i < x + 8; i++) {
            if(i != x) {//첫째 줄이 아닌 경우
                if(pre ^ map[i][y]) { //끝에 꺼랑 다른 경우
                    pre = !map[i][y];
                    count++;
                }
            }
            for (int j = y + 1; j < y + 8; j++) {
                if (map[i][j] ^ pre) { //둘이 다른 경우
                    pre = map[i][j];
                } else { //둘이 같은 경우
                    pre = !map[i][j];
                    count++;
                }
            }
        }
        if (count > 32) {
            return 64 - count;
        }

        return count;
    }
}
