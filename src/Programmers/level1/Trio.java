package Programmers.level1;

public class Trio {
    /**
     * 삼총사
     * @param number 한국중학교 학생들의 번호를 나타내는 정수 배열
     * @return 학생들 중 삼총사를 만들 수 있는 방법의 수
     */
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = i+1; j < number.length - 1; j++) {
                for (int k = j+1; k < number.length - 2; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
