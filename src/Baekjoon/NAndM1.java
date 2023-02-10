package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <문제>
 *     N과 M(1)
 *     input : 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 *     output : 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 *              수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 * </문제>
 * <문제풀이>
 *
 * </문제풀이>
 * <피드백>
 *     mapToInt는 반환 타입이 InputStream을 기억해야한다. 따라서 mapToInt를 사용한 경우엔 toArray를 통해 다시 배열의 형태로 만들어줘야한다.
 *     그냥 split을 사용할 수도 있지만, StringTokenizer을 사용할 수 있다.
 *         StringTokenizer st = new StringTokenizer(br.readLine());
 *         n = Integer.parseInt(st.nextToken());
 *         m = Integer.parseInt(st.nextToken());
 * </피드백>
 */
public class NAndM1 {

    static int n;
    static int m;
    static boolean[] visit; // 방문했는지 여부
    static int[] progression; // 각 자리의 수열이 저장된다.

    public static void dfs(int depth) {

        if (depth == m) {
            printSolution(progression);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                progression[depth] = i + 1; //행의 n번째 수열
                dfs(depth + 1);
                visit[i] = false; //false를 해야 1 2 후에 2 1이 가능하다.
            }
        }
    }

    public static void printSolution(int[] solution){
        for (int i : solution) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = input[0];
        m = input[1];

        visit = new boolean[n];
        progression = new int[m];

        dfs(0);
    }
}
