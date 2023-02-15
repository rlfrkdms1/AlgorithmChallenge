package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <문제>
 *     1,2,3 더하기
 *     input : 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
 *     output : 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
 * </문제>
 * <풀이>
 *     dp
 *     1 = 1
 *         -> 1개
 *     2 = 1 + 1
 *         2
 *         -> 2개
 *     3 = 1 + 1 + 1
 *         1 + 2
 *         2 + 1
 *         3
 *         -> 4개
 *     4 = 1 + 3 이므로 `1+`는 `3`의 개수인 4개이다.
 *         2 + 2 이므로 `2+`는 `2`의 개수인 2개이다.
 *         3 + 1 이므로 `3+`는 `1`의 개수인 1개이다.
 *         -> 7개
 *     따라서 점화식 : D(N) = D(N-3) + D(N-2) + D(N-1) 이다.
 * </풀이>
 * <피드백>
 *     dp 문제임을 알았고 여러 방식으로 패턴을 파악했는데, 또 문제를 제대로 숙지하지 않아 시간을 허무하게 사용했다.
 *     풀 수 있는 문제 였는데 여러모로 아쉬움이 남는다.
 *     solution을 main에 넣어주지 않아 답을 틀렸었다. 주의하자/
 * </피드백>
 */
public class SumOfOneTwoThree {

    static int[] dp = new int[12];

    public static void solution() {

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTest = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfTest; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }


}

