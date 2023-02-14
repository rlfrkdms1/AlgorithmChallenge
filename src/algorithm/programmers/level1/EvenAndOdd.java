package algorithm.programmers.level1;

public class EvenAndOdd {
    /**
     * 짝수와 홀수
     * @param num 정수
     * @return 짝수면 Even, 홀수면 Odd
     * 삼항 연산자 연습
     */
    public String solution(int num) {
        return (num % 2 == 0) ? "Even" : "Odd";
    }
}
