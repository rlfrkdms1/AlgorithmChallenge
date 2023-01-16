package level1;

public class CokeProblem {

    /**
     * @param a 콜라를 받기 위해 마트에 줘야하는 콜라 병 수
     * @param b 빈 병 a개를 받았을 때 마트가 주는 콜라 병 수
     * @param n 상빈이가 가지고 있는 빈 병의 개수
     * @return
     */
    public int solution(int a, int b, int n) {
        int answer = 0; //마트가 준 콜라 병 수의 총합
        int givenByMart = 0;

        while (n >= a) {
            givenByMart = (n / a) * b;
            n %= a;
            n += givenByMart;
            answer += givenByMart;
        }

        return answer;
    }

}
