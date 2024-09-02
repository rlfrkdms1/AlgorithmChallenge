import java.util.*;

class MineralMining {

    int answer = Integer.MAX_VALUE;
    String[] minerals;
    int[] picks;
    Map<Integer, Map<String, Integer>> mineralValue =
            Map.of(
                    0,
                    Map.of("diamond", 1, "iron", 1, "stone", 1),
                    1,
                    Map.of("diamond", 5, "iron", 1, "stone", 1),
                    2,
                    Map.of("diamond", 25, "iron", 5, "stone", 1));

    public int solution(int[] picks, String[] minerals) {
        this.minerals = minerals;
        this.picks = picks;
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0) continue;
            picks[i]--;
            dfs(i, 0, 0);
            picks[i]++;
        }
        return answer;
    }

    public void dfs(int type, int fatigue, int index) {

        if (answer < fatigue) { // 피로도가 이미 최소값을 넘었을 때
            return;
        }

        if (index == minerals.length) { // 끝까지 다 돌았을 때
            if (fatigue < answer) answer = fatigue;
            return;
        }

        Map<String, Integer> value = mineralValue.get(type);
        for (int i = index; i < index + 5; i++) {
            if (i == minerals.length) {
                if (fatigue < answer) {
                    answer = fatigue;
                }
                return;
            }
            fatigue += value.get(minerals[i]);
        }

        if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            if (fatigue < answer) answer = fatigue;
            return;
        }
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0) continue;
            picks[i]--;
            dfs(i, fatigue, index + 5);
            picks[i]++;
        }
    }
}
