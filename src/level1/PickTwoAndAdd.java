package level1;

import java.util.ArrayList;
import java.util.List;

public class PickTwoAndAdd {

    /**
     * 두 개 뽑아서 더하기
     * @param numbers 정수 배열
     * @return numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수(오름차순)
     * list를 사용하지 않고 set을 사용하면 distinct를 사용하지 않아도 된다.
     */
    public int[] solution(int[] numbers) {

        List<Integer> addList = new ArrayList<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                addList.add(numbers[i] + numbers[j]);
            }
        }

        return addList.stream().distinct().sorted().mapToInt(i -> i).toArray();
    }
}
