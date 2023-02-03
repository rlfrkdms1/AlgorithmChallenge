package Programmers.level1;

public class HighestAndLowestRankingsOfLotto {

    /**
     * <문제>
     *     로또의 최고 순위와 최저 순위
     *     @param lottos 민우가 구매한 로또 번호를 담은 배열
     *     @param win_nums 당첨 번호를 담은 배열
     *     @return 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담은 배열
     * </문제>
     * <문제풀이>
     *     1. missNum : 알아볼 수 없는 번호의 개수
     *     2. correctNum : 당첨 번호와 민우의 번호(알아볼 수 있는 번호 중)가 일치하는 수
     *     3. 2중 for문을 사용해 missNum과 correctNum을 찾는다.
     *     4. 최고 순위 : 알아볼 수 없는 번호가 모두 당첨된 경우이다.
     *     correctNum + missNum이 당첨 개수이므로 이를 7에서 빼면 순위가 되지만 6등은 당첨개수가 1개 혹은 0개 이므로
     *     if문을 이용해 만약 correctNum + missNum <= 1이면 6위라 한다.
     *     5. 최저 순위 : 알아볼 수 없는 번호가 모두 낙첨된 경우이다.
     *     4와 같이 if문을 사용해 6등일 경우를 고려한다.
     * </문제풀이>
     * <피드백>
     *     return int[] {a,b} 와 같은 배열 형태를 사용할 수 있다.
     *     else문이 아닌 continue를 사용해 depth를 줄일 수 있다.
     *     각각의 순위를 6위인 경우를 고려하지 않고 설정한 다음 6위인 경우를 고려하는 것이 낫다.
     *     ex) int highestRank = 7 - (correctNum + missNum)
     *         if (highestRank > 6) highestRank = 6
     * </피드백>
     */
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int missNum = 0;
        int correctNum = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                missNum++;
            } else {
                for (int j = 0; j < win_nums.length; j++) {
                    if (win_nums[j] == lottos[i]) {
                        correctNum++;
                        break;
                    }
                }
            }
        }

        if (correctNum + missNum <= 1) {
            answer[0] = 6;
        } else {
            answer[0] = 7 - (correctNum + missNum);
        }

        if (correctNum <= 1) {
            answer[1] = 6;
        }else {
            answer[1] = 7-correctNum;
        }
        return answer;
    }
}
