package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Phonekemon {

    /**
     * <문제>
     *     폰켓몬
     *     @param nums N마리 포켓몬의 종류 번호가 담긴 배열
     *     @return 가장 많은 종류의 포켓몬을 선택하는 방법을 찾아 그때의 포켓몬 종류 번호의 개수
     * </문제>
     * <문제풀이>
     *     1. phonekemon의 번호 별 수를 phonekemons에 넣는다.
     *     2. phonekemon의 종류가 N/2보다 크다면 가져갈 수 있는 최대 크기가 N/2이므로 N/2를 반환한다.
     *     3. phonekemon의 종류가 N/2보다 작다면 phonekemon의 size만큼의 종류를 가져갈 수 있으므로 size를 반환한다.
     * </문제풀이>
     * <피드백>
     *     중복되는 포켓몬 수를 셀 필요가 없다. 따라서 set을 사용하는 것이 더 간편하다.
     *     return 하는 로직을 더 간편히 줄일 수 있을 텐데
     * </피드백>
     *  */
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> phonekemons = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            phonekemons.put(nums[i], phonekemons.getOrDefault(nums[i], 0) + 1);
        }

        if (phonekemons.size() >= nums.length / 2) {
            return nums.length / 2;
        } else {
            return phonekemons.size();
        }
    }

    /**
     * <다른분의 풀이>
     *     1. set으로 중복을 줄인 것
     *     2. size와 length/2 중 min 값을 찾은 것
     * </다른분의 풀이>
     */
    public int solutionAnother(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }
}
