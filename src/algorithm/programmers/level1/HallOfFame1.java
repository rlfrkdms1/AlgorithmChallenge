package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HallOfFame1 {

    /**
     * @param k 명예의 전당 목록의 점수의 개수
     * @param score 1일부터 마지막 날까지 출연한 가수들의 점수
     * @return 매일 발표된 명예의 전당의 최하위 점수
     * 우선순위 큐를 이용해보자.
     * score의 인덱스인 i는 0부터 시작하는데 k는 그대로 사용하여 문제가 생겼다. k에도 1을 빼줘 해결했다.
     */
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {

            scores.add(score[i]);
            Collections.sort(scores, Comparator.reverseOrder());

            if (i < k-1) {
                answer[i] = scores.get(i);
            } else {
                answer[i] = scores.get(k-1);
            }
        }

        return answer;
    }

}
