package Programmers.level1;

public class TheNearestSameLetter {

    /**
     * @param s 문자열
     * @return s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지
     */
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            answer[i] = -1; //초기화
            for (int j = 0; j <i; j++) {
                if (s.substring(j, j + 1).equals(s.substring(i, i + 1))) {
                    answer[i] = i - j;
                }
            }
        }
        return answer;
    }

}
