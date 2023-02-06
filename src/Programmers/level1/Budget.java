package Programmers.level1;

import java.util.Arrays;

public class Budget {

    /**
     * <문제>
     *     @param d 부서별로 신청한 금액이 들어있는 배열
     *     @param budget 예산
     *     @return 최대 몇 개의 부서에 물품을 지원할 수 있는지
     * </문제>
     * <문제풀이>
     *     1. d를 정렬한다.
     *     2. 작은 예산을 신청한 부서를 지원해주는 것이 최대로 지원해줄 수 있는 것이므로 가장 작은 금액부터 더해가며
     *        budget 이하일 때 까지의 개수를 구한다.
     * </문제풀이>
     * <피드백>
     *     budget에서 d[i]를 빼는 방법도 있다. 이 방법을 쓰면 total과 같은 변수를 사용하지 않아도 된다.
     * </피드백>
     *
     */
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        int total = 0;
        for (int i = 0; i < d.length; i++) {
            total += d[i];
            if (total <= budget) {
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }

}
