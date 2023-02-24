package algorithm.programmers.level3;

public class Network {

    int n;
    int[][] computers;
    boolean[] visit;

    /**
     * <문제>
     *     네트워크
     *     @param n 컴퓨터의 개수
     *     @param computers 연결에 대한 정보가 담긴 2차원 배열
     *     @return 네트워크의 개수
     * </문제>
     * <풀이>
     *     컴퓨터의 연결이 양방향이므로 컴퓨터를 돌아가며 탐색하지 않은 컴퓨터에 대해 탐색한다.
     *     탐색한 컴퓨터엔 방문 체크를 해주고 한번 탐색이 끝날 때 마다 count를 해준다.
     * </풀이>
     * <피드백>
     *     아무리 봐도 반례가 없고, 아무리 봐도 틀릴 게 없어서 한참을 질문하기 가서 반례도 보고, 남들 답안도 봤는데 답이 안나왔다.
     *     근데 처음부터 다시 보니 dfs(0)이 되어있었다. 보통 dfs문제는 0부터 탐색하는 경우가 많아 dfs(0)을 먼저 해놓고 바꾸지 않은 것이었다.
     *     진짜 이상한 실수를 했다.
     * </피드백>
     */
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        this.n = n;
        this.computers = computers;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int computerNum) {
        visit[computerNum] = true;
        for (int i = 0; i < n; i++) {
            if (i != computerNum && !visit[i] && computers[computerNum][i] == 1) {
                dfs(i);
            }
        }
    }

}
