package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class MockTest {

    /**
     * @param answers 문제의 정답이 순서대로 들은 배열
     * @return 가장 많은 문제를 맞힌 사람이 누구인지 담은 배열
     * score를 각각의 변수에 담는 것이 좋을지 배열에 담는 것이 좋을지 고민을 많이 했다.
     * 배열에 담으면 관리하기는 쉬우나, index가 0부터 시작하여 각각의 index가 누구의 성적을 나타내는지
     * 나만 알 수 있는 것이 단점이라고 생각했다.
     * 하지만 각각의 변수로 만들기엔 만약 학생의 수가 늘어났을 경우 변수가 너무 많아져 배열을 택했다.
     * 또한 가장 큰 값을 찾을 땐 max 함수를 사용해보도록하자
     */
    public int[] solution(int[] answers) {

        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] studentScore = new int[3];

        int answer;
        //1. 답 맞추기
        for (int i = 0; i < answers.length; i++) {
            answer = answers[i];
            if (student1[i % 5] == answer) {
                studentScore[0]++;
            }
            if (student2[i % 8] == answer) {
                studentScore[1]++;
            }
            if (student3[i % 10] == answer) {
                studentScore[2]++;
            }
        }

        //2. 답 개수를 비교해서 최대 값 찾기
        int max = 0;
        for (int i : studentScore) {
            if (i > max) {
                max = i;
            }
        }

        List<Integer> answerList = new ArrayList<>();
        //3. 최대 개수를 맞힌 학생
        for (int i = 0; i < studentScore.length; i++) {
            if (studentScore[i] == max) {
                answerList.add(i+1);
            }
        }

        return answerList.stream().mapToInt(i->i).toArray();
    }
}
