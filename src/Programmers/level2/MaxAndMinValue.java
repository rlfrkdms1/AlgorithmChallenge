package Programmers.level2;

import java.util.Arrays;

public class MaxAndMinValue {

    /**
     * <문제>
     *     최댓값과 최솟값
     *     @param s 문자열
     *     @return "(최소값) (최대값)"형태의 문자열
     * </문제>
     * <문제풀이>
     *     1. s를 split을 이용해 String 배열에 하나씩 잘라 넣는다.
     *     2. string 배열을 int 배열로 변환한다.
     *     3. stream을 이용해 max와 min값을 찾는다.
     *     4. 공백을 붙여 반환
     * </문제풀이>
     * <피드백>
     *     Arrays.sort()를 이용해서 맨앞에 있는 값과 맨뒤에 있는 값으로 min과 max를 구할 수 있다.
     * </피드백>
     */
    public String solution(String s){
        String[] strings = s.split(" ");

        int[] ints = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        int max = Arrays.stream(ints).max().getAsInt();
        int min = Arrays.stream(ints).min().getAsInt();

        return min + " " + max;
    }

    /**
     * 예전에 했던 풀이
     * stream을 사용하지 않고 int 배열을 만들고 for문을 이용해 int형으로 바꿔줬다.
     * 왜 int배열이 아니고 Integer 배열이지 ..?
     * answer를 안쓰고 그냥 반환해도 될 것 같다. 
     */
    static class ExSolution {
        class Solution {
            public String solution(String s) {
                String answer = "";
                String[] numbers = s.split(" ");
                Integer[] newNumbers = new Integer[numbers.length];

                int i =0;
                for (String number : numbers) {
                    newNumbers[i++] = Integer.parseInt(number);
                }
                int max=newNumbers[0];
                int min = newNumbers[0];
                for (Integer number : newNumbers) {
                    if (number > max) {
                        max = number;
                    } else if (number < min) {
                        min = number;
                    }
                }
                answer=min + " " + max;
                return answer;
            }
        }
    }
}
