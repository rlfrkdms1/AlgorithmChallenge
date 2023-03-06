package algorithm.programmers.level2;

/**
 * <문제>
 *     피로도
 *     input : 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons
 *     output : 유저가 탐험할수 있는 최대 던전 수
 * </문제>
 * <퓰이>
 *     dfs를 이용한 완전 탐색으로 풀었다.
 *     dfs만 이용할 줄 안다면 금방 풀 수 있는 문제인 것 같다.
 * </퓰이>
 *<피드백>
 *     해당 문제에서 다시 탐색하지 않을 조건으로는 피로도 검색과 visit 판별이 있다.
 *     따라서 visit를 사용하지 않고 피로도를 9999로 올린다면 visit를 사용하지 않아도 된다.
 *     dungeons[index][0] = 9999;
 *     dfs();
 *     dungeons[index][0] = 원래 있던 값;
 *     (아래 다른분의 풀이를 확인하면 된다. )
 *</피드백>
 *
 */
public class Fatigue {

    int k, answer;
    int[][] dungeons;
    boolean[] visit;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        this.k = k;
        this.dungeons = dungeons;
        visit = new boolean[dungeons.length];

        for(int i = 0; i < dungeons.length; i++){
            if(k >= dungeons[i][0]){
                dfs(i,k, 1);
                visit[i] = false;
            }
        }
        return answer;
    }

    public void dfs(int index, int fatigue, int count){
        if(answer<count){
            answer = count;
        }
        visit[index] = true;
        int tempFatigue = fatigue - dungeons[index][1];
        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i] && dungeons[i][0] <= tempFatigue){
                dfs(i, tempFatigue, count+1);
                visit[i] = false;
            }
        }
    }

    static class AnotherSolution {

        int dfs(int k, int[][] dungeons) {
            int cnt = 0;
            for(int[] d : dungeons) {
                int a = d[0], b = d[1];
                if(a <= k) {
                    d[0] = 9999;
                    cnt = Math.max(1 + dfs(k - b, dungeons), cnt);
                    d[0] = a;
                }
            }
            return cnt;
        }
        public int solution(int k, int[][] dungeons) {
            int answer = -1;
            return dfs(k, dungeons);
        }
    }
}
