package level1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FailureRate {

    /**
     * <문제>
     *     실패율
     *     @param N 전체 스테이지 개수
     *     @param stages 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
     *     @return 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열
     * </문제>
     *
     * <문제 풀이>
     *     1. [스테이지 level : 실패율] - failureRate
     *     2. 해당 스테이지를 도전한 사람 수 - challenge
     *     3. 해당 스테이지에 머물러 있는 도전자 수 - totalUser
     *     4. stages를 모두 돌면서 각각의 스테이지에 몇명의 사람이 도전했는지 확인
     *     5. 실패율 계산 ** 분모에 0이 들어가도록 나누기를 하면 Nan값이 들어감 **
     *     6. map 정렬
     * </문제 풀이>
     *
     * <피드백>
     *     항상 문제를 꼼꼼히 읽어볼 것
     *     아무도 도전하지 못한 스테이지가 있을 예외를 생각해야 한다. 예시로 N이 5일 때 stages = {1,2,3}이라면 stage 4,5는 실패율이 0이다.
     *     제한 사항을 잘 읽어보면 알 수 있는 예외사항인데, 놓쳤다.
     * </피드백>
     *
     * */

    public int[] solution(int N, int[] stages) {

        Map<Integer, Double> failureRate = new HashMap<>(); // 실패율
        for (int i = 0; i < N; i++) {
            failureRate.put(i + 1, 0.0); // 실패율 0일 경우를 위해 초기화
        }

        int[] challenge = new int[N]; //스테이지 별 도전자 수
        int[] totalUser = new int[N+1]; // 스테이지 별 머물러 있는 도전자 수

        for (int i = 0; i < stages.length; i++) { // 스테이지0 ~ N-1
            totalUser[stages[i]-1]++; //해당 스테이지에 멈춰있는 인원
            for (int j = 0; j < stages[i]; j++) { // 참가자별
                if(j>=N) break; // 모든 스테이지를 클리어 한 사람의 마지막 스테이지
                challenge[j]++;
            }
        }

        for (int i = 0; i < challenge.length; i++) {
            if (challenge[i] != 0) {
                failureRate.put(i+1, totalUser[i]/(double)challenge[i]);
            }
        }

        int[] answer = failureRate.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .mapToInt(i->i)
                .toArray();

        return answer;
    }

}
