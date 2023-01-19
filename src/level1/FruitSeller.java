package level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitSeller {

    /**
     * @param k 사과의 최대 점수
     * @param m 한 상자에 담긴 사과 개수
     * @param score 사과들의 점수
     * @return 과일 장수가 얻을 수 있는 최대 이익
     * List로 바꿀 필요 없이 array를 쓰면 좋을 듯
     */
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> scores = Arrays.stream(score).sorted().boxed().collect(Collectors.toList());
        int count = 0;

        for (int i = score.length - 1; i > (score.length % m) - 1; i--) {
            if (++count % m == 0) {
                answer += scores.get(i);
            }
        }

        answer *= m;

        return answer;
    }

    /* 다른 분의 풀이
    for문의 조건문을 잘 사용하면 count도 사용안해도 될 뿐더러 m과 나눈 나머지를 구할 필요도 없었다.
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }

        return answer;
    }
     */

}
