package algorithm.baekjoon;

import java.io.*;

/**
 * <문제>
 *     RGB 거리
 *     input : 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
 *     output : 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 * </문제>
 * <풀이>
 *     정수 삼각형과 비슷한 문제라고 생각하면 된다.
 *     중요한 것은 houses[i][0] += Math.min(houses[i-1][1], houses[i-1][2]이다.
 *     1번 집부터 N번 집까지 for문을 돌리는데, 이전 집에서 칠한 색 빼고 나머지 두 색에 대한 비용을 비교해 최솟 값을 지금 집 비용에 더한다.
 *     모든 색 별로 위의 연산이 이루어지며, 비용은 누적된다.
 *     따라서 결과값은 마지막 N번째 집의 각각의 색 비용 중 최솟값이 된다.
 * </풀이>
 * <피드백>
 *     입력과 동시에 비용을 더하는 방법도 있다. 예를 들자면 아래와 같다.
 *     for(int i = 0; i < numOfHouse; i++) {
 *             String[] house = br.readLine().split(" ");
 *             for(int j = 0; j < 3; j++ ){
 *                 houses[i][j] = Integer.parseInt(house[j]);
 *             }
 *             if(i!=1){
 *                 houses[i][0] += Math.min(houses[i-1][1], houses[i-1][2]);
 *                 houses[i][1] += Math.min(houses[i-1][0], houses[i-1][2]);
 *                 houses[i][2] += Math.min(houses[i-1][0], houses[i-1][1]);
 *             }
 *         }
 * </피드백>
 */
class RGBStreet {

    static int[][] houses;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfHouse = Integer.parseInt(br.readLine());
        houses = new int[numOfHouse][3];
        for(int i = 0; i < numOfHouse; i++) {
            String[] house = br.readLine().split(" ");
            for(int j = 0; j < 3; j++ ){
                houses[i][j] = Integer.parseInt(house[j]);
            }
        }

        for(int i = 1; i < numOfHouse; i++) {
            houses[i][0] += Math.min(houses[i-1][1], houses[i-1][2]);
            houses[i][1] += Math.min(houses[i-1][0], houses[i-1][2]);
            houses[i][2] += Math.min(houses[i-1][0], houses[i-1][1]);
        }

        System.out.println(Math.min(houses[numOfHouse-1][0], Math.min(houses[numOfHouse-1][1], houses[numOfHouse-1][2])));
    }
}