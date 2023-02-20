package algorithm.baekjoon;

import java.io.*;
import java.util.*;

/**
 * <문제>
 *     단지 번호 붙이기
 *     input : 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 *     output : 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 * </문제>
 * <풀이>
 *     dfs를 사용해서 풀이했다.
 *     groupId를 통해 count를 세었고, 4방 탐색을 이용했다.
 * </풀이>
 * <피드백>
 *     Map 보다 더 좋은 건 없었을까 map은 정렬을 아직 못외워 불안하다. 
 * </피드백>
 */
class ComplexNumbering {

    static boolean[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int n;

    static int groupId;
    static Map<Integer, Integer> group;

    public static void dfs(int x, int y, int groupId){

        if(!visited[x][y]){
            visited[x][y] = true;
            group.put(groupId, group.getOrDefault(groupId, 0)+1);
            if(map[x][y]){
                for(int i = 0; i < 4; i++){
                    int tempx = x + dx[i];
                    int tempy = y + dy[i];
                    if(tempx>=0 && tempx<n && tempy>=0 && tempy<n && map[tempx][tempy]){
                        dfs(tempx,tempy,groupId);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String[] split = br.readLine().split("");
            for(int j = 0; j < n; j++){
                if(split[j].equals("1")){
                    map[i][j]=true;
                }
            }
        }
        groupId = 0;
        group = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]&&map[i][j]){
                    dfs(i,j,groupId);
                }
                groupId++;
            }
        }

        System.out.println(group.size());
        group.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getValue()));

    }
}