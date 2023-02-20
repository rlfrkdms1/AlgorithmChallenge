package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <문제>
 *     오르막 수
 *     input : 첫째 줄에 N (1 ≤ N ≤ 1,000)이 주어진다.
 *     output : 첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.
 * </문제>
 * <풀이>
 *     N이 1이라면
 *     0 1 2 3 4 5 6 7 8 9
 *     로 오르막을 만들 수 있다.
 *     N이 2라면
 *     '0_' -> 0 1 2 3 4 5 6 7 8 9
 *     '1_' -> 1 2 3 4 5 6 7 8 9
 *     '2_' -> 2 3 4 5 6 7 8 9
 *     '3_' -> 3 4 5 6 7 8 9
 *     '4_' -> 4 5 6 7 8 9
 *     '5_' -> 5 6 7 8 9
 *     ...
 *     와 같이 맨 앞에 오는 수를 i라 하고 맨앞자리에 i가 고정될 경우 만들어질 수 있는 경우의 수는 i부터 9까지의 개수이다.
 *     따라서 N번째의 i번째 행의 개수는 N-1의 i부터 9까지의 합이다.
 * </풀이>
 * <피드백>
 *     또 나머지를 출력하라는 말을 못봐 자꾸 틀렸다.
 *     나머지를 구하는 연산의 위치는 가장 세부적인 곳에 들어가야한다.
 *     마지막 출력시에도 나머지 연산을 하는 것을 잊지 말아야 한다.
 *
 *     for문 내에서 sum을 사용하지 않고 그냥 dp[i][j]를 사용해도 된다.
 *     dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007
 * </피드백>
 */
public class AscendingNumber {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][10];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 10; j++){
                if(i == 0){
                    dp[i][j] = 1;
                }else {
                    int sum = 0;
                    for(int k = j; k < 10; k++){
                        sum = (sum + dp[i - 1][k]) % 10007;
                    }
                    dp[i][j]=sum;
                }

            }
        }
        int answer = 0;
        for(int i = 0; i < 10; i++){
            answer += dp[N-1][i];
        }
        System.out.println(answer % 10007);
    }
}
