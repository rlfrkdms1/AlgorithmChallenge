package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <문제>
 *     계단 오르기
 *     input : 입력의 첫째 줄에 계단의 개수가 주어진다.
 *     둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.
 *     output : 첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.
 * </문제>
 */
public class ClimbingStairs {


    /**
     * <dfs 풀이>
     *     메모리 초과로 실패했지만, 테스트에서 예제는 통과했다.
     * </dfs>
     * <문제풀이>
     *     맨 처음 계단을 밟거나, 안밟거나로 먼저 나누어
     *         dfs(0, 0, 0);
     *         dfs(1, 0, 0);
     *     로 나누어 실행했다.
     *     continued를 통해 연속으로 계단을 밟았는지 확인했고, temp를 통해 현재 행해지는 dfs의 점수를 담았다.
     *     depth가 length를 지나치면 마지막 계단을 밟지 않은것이므로 그냥 return하고,
     *     depth가 length-1과 같다면 마지막 계단을 밟은 것이므로 마지막 계단의 점수를 더해주고 score에 더해주었다.
     * </문제풀이>
     * <피드백>
     *     continued를 boolean으로 처리할 수 있을 것 같다.
     *     마지막 계단을 밟지 않는 경우의 처리가 미흡했었다. 
     * </피드백>
     */
    static int[] stairs;
    static List<Integer> scores = new ArrayList<>();
    static int length;

    public static void dfs(int depth, int continued, int temp) {
        if (depth >= length) {
            return;
        }
        if (depth == length-1) {
            scores.add(temp+stairs[length-1]);
            return;
        }

        if (continued < 1) {
            continued++;
            temp += stairs[depth];
            dfs(depth + 1, continued, temp);
            dfs(depth + 2, 0, temp);
        } else {
            temp += stairs[depth];
            dfs(depth + 2, 0, temp);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        stairs = new int[length];
        for (int i = 0; i < length; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dfs(0, 0, 0);
        dfs(1, 0, 0);

        System.out.println(Collections.max(scores));
    }
}
