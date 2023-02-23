package algorithm.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class GameMapShortestDistance {

    /**
     * <문제>
     *     게임 맵 최단거리 - bfs
     *     @param maps 게임 맵의 상태
     *     @return 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값
     * </문제>
     * <풀이>
     *     queue를 생성해 사방 탐색을 활용해 bfs로 풀었다.
     *     x,y좌표는 node를 생성해 사용하였다.
     * </풀이>
     * <피드백>
     *     처음엔 visit를 사용했는데 효율성에서 문제가 생겼다.
     *     그래서 visit 대신 map을 사용해 이미 탐색한 곳은 0으로 지정해주니 효율성 문제를 통과했다.
     *     value를 따로 지정하지 않고 map에 바로 더하는 방법도 있다.
     *     maps[go_x][go_y] = maps[temp_x][temp_y]+1;
     * </피드백>
     */
    public int solution(int[][] maps) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Node> queue = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;

        queue.offer(new Node(0, 0, 1));
        maps[0][0] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int temp_x = node.x;
            int temp_y = node.y;

            if (temp_x == n - 1 && temp_y == m - 1) {
                return node.value;
            }


            for (int i = 0; i < 4; i++) {
                int go_x = temp_x + dx[i];
                int go_y = temp_y + dy[i];
                if (go_x >= 0 && go_x < n && go_y >= 0 && go_y < m &&
                        maps[go_x][go_y] == 1) {
                    maps[go_x][go_y] = 0;
                    queue.offer(new Node(go_x, go_y, node.value + 1));
                }
            }
        }
        return -1;
    }


    static class Node {
        int x;
        int y;
        int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

    }

    /**
     * <문제>
     *     게임 맵 최단거리 - dfs
     * </문제>
     * <피드백>
     *     효율성에서 통과되지 못했다. 최단 거리를 구하는 문제는 bfs를 쓰는게 답인 것 같다.
     *     min 값을 처음에 -1로 두고 시작하니 min과 value를 비교할 때 당연히 계속 value가 더 커 min에는 -1만 남게 되었다.
     *     또한 dfs는 탐색한 곳도 다시 탐색해야하기 때문에 maps에서 탐색한 곳을 0 으로 설정했어도 dfs가 끝난 후 1로 바꿔줘야 재탐색할 수 있다다
    * </피드백>
     */
    int min, n, m;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][] maps;

    public int solution_dfs(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        min = -1;
        this.maps = maps;
        dfs(0, 0, 1);
        return min;
    }

    public void dfs(int x, int y, int value) {

        if (x == n - 1 && y == m - 1) {
            if (min > value || min == -1) {
                min = value;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int go_x = x + dx[i];
            int go_y = y + dy[i];
            if (go_x >= 0 && go_x < n && go_y >= 0 && go_y < m &&
                    maps[go_x][go_y] == 1) {
                maps[go_x][go_y] = 0;
                dfs(go_x, go_y, value + 1);
                maps[go_x][go_y] = 1;
            }
        }
    }
}
