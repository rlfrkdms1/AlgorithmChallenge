package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * <문제>
 *      01타일
 *      input : 첫 번째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 *      output : 첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.
 * </문제>
 * <풀이>
 *     N = 1 : 1 -> 1
 *     N = 2 : 11 00 -> 2
 *     N = 3 : 111 100 001 -> 3
 *     N = 4 : 1111 1100 1001 0011 0000 -> 5
 *     따라서 '00_'인 경우와 '100_'인 경우, '11_'인 경우로 나누어 점화식은 dp[i] = dp[i-2]*2 + dp[i-3]이 되었다.
 *     하지만 아래의 피드백에서와 같이 '00_'인 경우와 '1_'인 경우로만 나누어도 된다. 그럼 점화식은 dp[i]=dp[i-1]+dp[i-2]이 된다.
 * </풀이>
 * <피드백>
 *     원래는 출력문에서 나누기를 했지만, 계속 오답 처리되었다.
 *     이는 값이 너무 커쳐 오버 플로우가 나 이상한 값이 들어가서 그런 것이었다.
 *     따라서 dp에 값을 넣을 때 마다 나누기를 해주기로 했다.
 *     앞으로 값이 너무 커 특정 값은 나눈 나머지를 출력하는 경우엔 오버 플로우를 예상하고 미리 나누는 연습을 하자.
 *
 *     나는 점화식으로 dp[i] = dp[i-2]*2 + dp[i-3]을 생각했으나 이는 dp[i]=dp[i-1]+dp[i-2]와 같다.
 *     dp[i-2]*2 + dp[i-3] = dp[i-2] + dp[i-2] + dp[i-3] = dp[i-2] + dp[i-1]
 * </피드백>
 */
public class Tile01 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i <= 3) {
                dp[i] = i;
            }
            dp[i] = (dp[i - 2]*2+ dp[i - 3])%15746;
        }
        System.out.println(dp[n]);
    }

}
