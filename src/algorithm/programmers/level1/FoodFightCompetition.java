package algorithm.programmers.level1;

public class FoodFightCompetition {

    /**
     * @param food 준비한 음식의 양을 칼로리가 적은 순서대로 나타내는 정수 배열
     * @return 대회를 위한 음식의 배치를 나타내는 문자열
     */
    public String solution(int[] food) {
        String answer = "";
        int[] numOfFood = new int[food.length];
        for (int i = 0; i < food.length; i++) {
            numOfFood[i] = food[i] / 2;
        }
        for (int i = 0; i < numOfFood.length; i++) {
            if (numOfFood[i] != 0) {
                for (int j = 0; j < numOfFood[i]; j++) {
                    answer += i;
                }
            }
        }

        answer += "0" + new StringBuffer(answer).reverse();


        return answer;
    }

    /*
    다른 분의 풀이
    public String solution(int[] food) {
        String answer = "0";

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i;
            }
        }

        return answer;
    }
    물을 기준으로 양옆을 채워나가는 방식이 새롭다.
    또한 food 중 answer에 들어가지 않을 요소들을 if문으로 거르지 않고, 반복문의 조건문을 통해 걸러낸 것이 인상적이다.
     */
}
