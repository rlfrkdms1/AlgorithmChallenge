package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SelectTangerine {

    /**
     * <문제>
     *     @param k 경화가 한 상자에 담으려는 귤의 개수
     *     @param tangerine 귤의 크기를 담은 배열
     *     @return 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값
     * </문제>
     * <풀이>
     *     1. tangerines map에 key는 귤의 크기, value는 귤의 크기에 따른 개수를 담는다.
     *     2. 개수를 기준으로 내림차순 정렬한다. (종류가 최대한 적어야 하기 때문에 같은 크기의 개수가 큰 것을 먼저 뽑을 것이기 때문에)
     *     3. k만큼 귤을 고른다.
     * </풀이>
     * <피드백>
     *     map을 sort한 후 처리하는 방법에대해 헷갈려 구글링을 했다.
     *     아래와 같이 stream을 사용하는 방법도 있으나, AnotherSolution의 풀이처럼 하는 방법도 있고, List에 value값만 넣어서 내림차순 정렬한 다음 사용하는 법도 있다.
     *     귤을 고르는 과정에선 key값이 필요하지 않으니 마지막 방법이 가장 유용할 것이다.
     *
     *      List<Integer> valueList = new ArrayList(map.values());
     *      Collections.sort(valueList,Collections.reverseOrder());
     * </피드백>
     */
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> tangerines = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            tangerines.put(tangerine[i], tangerines.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> collect = tangerines.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> tan : collect) {
            if (k <= 0) break;
            Integer select = tan.getValue();
            k -= select;
            answer++;
        }
        return answer;
    }

    static class AnotherSolution {

        public int solution(int k, int[] tangerine) {
            int answer = 0;
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int t : tangerine) {
                map.put(t, map.getOrDefault(t, 0) + 1);
            }

            List<Integer> list = new ArrayList<>(map.keySet());
            list.sort((o1, o2) -> map.get(o2) - map.get(o1));

            for (Integer key : list) {
                k -= map.get(key);
                answer++;
                if (k <= 0) {
                    break;
                }
            }

            return answer;
        }
    }
}


