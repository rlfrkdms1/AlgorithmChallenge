package algorithm.programmers.level2;

import java.util.Arrays;

public class Hopscotch {

    /**
     * <문제>
     *     땅따먹기
     *     @param land N행 4열로 이루어진 땅따먹기 게임의 땅
     *     @return 마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값
     * </문제>
     * <풀이>
     *     정수삼각형, RGB거리랑 유형이 같은 dp문제이다.
     *     (i,j)번째에 j열을 제외한 i-1 행의 값들 중 최댓값을 찾아 (i,j)에 더해주고,
     *     마지막 행까지 모두 내려왔을 때 마지막 행에서 가장 큰 값을 찾아 반환하면 된다.
     * </풀이>
     */
    int solution(int[][] land) {

        for(int i = 1; i < land.length; i++){
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        return Arrays.stream(land[land.length-1]).max().getAsInt();
    }
}
