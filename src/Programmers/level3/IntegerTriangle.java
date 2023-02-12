package Programmers.level3;

import java.util.Arrays;

public class IntegerTriangle {

    /**
     * <문제>
     *  * 정수 삼각형
     *  @param triangle 삼각형의 정보가 담긴 배열
     *  @return 거쳐간 숫자의 최댓값
     * </문제>
     * <문제풀이>
     *     1. triangle과 같은 크기를 가진 dp를 선언한다.
     *     2. dp의 맨윗단엔 triangle의 맨윗단과 같은 값을 넣어준다.
     *     3. triangle을 돌면서 n행에 올 수 있는 최댓값들을 dp에 넣어준다.
     *        (만약 삼각형의 높이가 3이고 [[7],[1,2],[0,9,3]]이라는 삼각형이 주어졌다고 가정하자.
     *        삼각형은 아래 두개의 값, 즉 i,j 번째는 i+1,j와 i+1,j+1로 갈 수 있다.
     *        0행에는 위의 행이 없으니 7이 최댓값이다. 따라서 dp[0][0]=7을 넣어준다.
     *        1행은 각각 7을 더한 값이 최댓값이다. 따라서 각각 8,9를 dp에 넣는다.
     *        2행에서 1열을 살펴보자. 1열로 올 수 있는 루트는 다음과 같이 두가지이다.
     *        1. [7,1,9]
     *        2. [7,2,9]
     *        이때 dp의 1행에 각각 8,9가 있으니 다음과 같다.
     *        1. [8,9]
     *        2. [9,9]
     *        따라서 2번이 최댓값이다.
     *     4. dp의 마지막 행의 최댓값을 구한다.
     * </문제풀이>
     * <피드백>
     *     처음에는 dp=triangle을 사용했다. 하지만 이후 로직에서 triangle의 값을 바꿔주지 않는데도, triagle의 값이 자꾸 바뀌어
     *     결과값이 이상해졌다. 그래서 도대체 이유가 뭘까 한참을 고민했는데, 그 순간 생각난게 java의 array라는 것. . .
     *     array는 객체이므로 triangle은 데이터가 들어있는 메모리의 참조값을 가리킨다.
     *     따라서 dp=triangle을 사용하면 dp엔 triangle의 참조값을 가리키게 돼 dp의 값이 바뀌면 triangle의 값도 바뀌게 된다.
     *     그래서 깊은 복사를 해야한다. . 깊은 복사를 하는 법은 블로그에 기록하자
     *     max값을 stream을 통해서 찾을 수 있었는데, 이중 배열이라 행을 어떻게 지정할 수 있는지를 몰라서 사용하지 못했다. 이는 아래의 다른 풀이를 보자.
     *     또한 dp[0][0]의 값은 항상 triangle[0][0]의 값으로 고정되는 사실을 잊지말고 계산전 미리 넣어줘야한다. for문에서는 [0][0]부터 시작해서 내려가는 연산이기 때문이다.
     *     만약 triangle을 복사했다면 괜찮았겠지만 배열을 새로 선언했으니 주의해야한다.
     * </피드백>
     */
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] dp = new int[height][height];
        dp[0][0]=triangle[0][0];
        for(int i = 0; i < triangle.length-1; i++){
            for(int j = 0; j < triangle[i].length; j++){
                int leftValue = dp[i][j]+triangle[i+1][j];
                if(leftValue > dp[i+1][j]){
                    dp[i+1][j] = leftValue;
                }

                int rightValue = dp[i][j]+triangle[i+1][j+1];
                if(rightValue > dp[i+1][j+1]){
                    dp[i+1][j+1]=rightValue;
                }
            }
        }

        int max=0;
        for(int i=0;i<height;i++){
            if(max<dp[height-1][i]){
                max=dp[height-1][i];
            }
        }
        return max;
    }

    /**
     * 이전에 계산한 값을 저장해두는 것을 메모이제이션이라고 하는데, 이를 triangle에 했다.
     * 아래의 풀이는 내 풀이와 다르게 아래에서부터 시작해 이러한 메모이제이션이 가능했다.
     * (나는 (1,1)일때 (2,1)과 (2,2)를 연산하고 (1,2)일 때 (2,2),(2,3)을 계산해 이 때 기존의 (2,2)와 새로운 (2,2)를 비교하는 방법을 사용했다.
     * 하지만 아래의 풀이는 (2,2)일 때 (1,1)과 (1,2)에서의 계산을 해 둘을 비교하는 법을 사용했다.
     *
     * stream을 사용해 max값을 가져왔다.
     */
    static class AnotherSolution {
        public int solution(int[][] triangle) {
            for (int i = 1; i < triangle.length; i++) {
                triangle[i][0] += triangle[i-1][0];
                triangle[i][i] += triangle[i-1][i-1];
                for (int j = 1; j < i; j++)
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }

            return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
        }
    }
}
