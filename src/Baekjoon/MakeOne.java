package Baekjoon;

import java.io.*;

/**
 * <문제>
 *     1로 만들기
 *     input : 첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.
 *     output : 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 * </문제>
 * <문제풀이>
 *     4 : 4 -> 2 -> 1
 *     5 : 5 -> 4 -> 2 -> 1
 *     6 : 6 -> 3 -> 1
 *     7 : 7 -> 6 -> 3 -> 1
 *     위와 같이 연산을 직접 해보면 알 수 있는 패턴은 아래와 같다.
 *     1. count(N) = count(N-1)+1
 *     2. count(N) = count(N/3)+1
 *     3. count(N) = count(N/2)+1
 *     따라서 위의 3가지 중 하나가 최솟 값인데, 2와 3번은 각각 N이 3과 2로 나누어 떨어져야한다.
 *     이를 종합해 2부터 N-1까지 횟수를 구하고 이를 토대로 N의 횟수를 구해 도출하면 된다.
 * </문제풀이>
 * <피드백>
 *     위 3가지 케이스 중 가장 작은 값을 도출해낼지 방법을 몰라서 한참 생각했다. min값을 넣기에도 애매하고,
 *     그렇다고 초기값을 넣자니 2번과 3번은 각각 나누어 떨어져야하는 수가 있어 값을 넣을 수가 없었다.
 *     고민은 의외로 쉽게 풀렸다. 바로 최솟값에 1번 케이스를 먼저 넣는 것 ..
 * </피드백>
 */
public class MakeOne{
    public static int solution(int n){
        int[] dp = new int[n + 1];

        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
            }

            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }
}
