package Programmers.level2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MakeJadenCase {

    /**
     * <문제>
     *     JadenCase 문자열 만들기
     *     @param s 문자열
     *     @return s를 JadenCase로 바꾼 문자열
     * </문제>
     * <문제풀이>
     *     1. split을 이용해 모든 문자를 lower한 후 하나씩 배열에 넣는다.
     *     2. 배열을 돌며 문자열을 돌며 전의 문자가 공백일 경우 해당 문자를 upper한다.
     *     3. answer에 붙인다.
     * </문제풀이>
     * <피드백>
     *     answer를 붙여서 반환하는 대신에 stream을 이용해 다음과 같이 반환할 수 있다.
     *     Arrays.stream(splitString).collect(Collectors.joining());
     * </피드백>
     */
    public String solution(String s) {
        String answer = "";
        String[] splitString = s.toLowerCase().split("");

        for (int i = 0; i < splitString.length; i++) {
            if (i == 0 || splitString[i - 1].equals(" ")) {
                splitString[i] = splitString[i].toUpperCase();
            }
            answer += splitString[i];
        }
        return answer;
    }

    /**
     * 공백을 기준으로 split해 배열에 담은 후 해당 배열의 각 요소(string)의 맨 앞글자를 substring을 이용해 upper한 뒤 뒤의 나머지 문자들과 다시 합쳤다.
     * 공백이 연속으로 있는 경우를 위해 if문을 사용했다.
     */
    static class exSolution {
        public String solution(String s) {
            String answer = "";
            String allLowerString = s.toLowerCase();
            String[] texts = allLowerString.split(" ");
            for (String text : texts) {
                if (text.equals("")) {
                    answer += " ";
                } else {
                    answer += text.substring(0, 1).toUpperCase() + text.substring(1) + " ";
                }
            }
            return answer.substring(0, s.length());
        }
    }
}
