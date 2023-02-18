package algorithm.baekjoon;

import java.io.*;
import java.util.*;

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