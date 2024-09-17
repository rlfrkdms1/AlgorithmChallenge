import java.util.*;
import java.lang.*;
import java.io.*;

class RobotVacuumCleaner {

    static int [][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //NXM
        StringTokenizer tz = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tz.nextToken());
        int M = Integer.parseInt(tz.nextToken());
        //(r,c) d
        tz = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(tz.nextToken());
        int c = Integer.parseInt(tz.nextToken());
        int d = Integer.parseInt(tz.nextToken());
        //map
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            tz = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tz.nextToken());
            }
        }
        int answer = 0;
        while(true) {
            //System.out.println("(" + r + ", " + c + ") / d = " + d);
            if(map[r][c] == 0) {
                map[r][c] = 2;
                answer++;
            }

            if(checkSurround(r,c)) { // 청소되지 않은 빈칸 존재
                d = turn(d);
                if(checkInMap(r+dx[d], c+dy[d]) && map[r+dx[d]][c+dy[d]] == 0) {
                    r += dx[d];
                    c += dy[d];
                }
            } else { //청소되지 않은 빈칸 존재 X
                int back = (d-2) < 0 ? d+2 : d-2;
                if(checkInMap(r+dx[back], c+dy[d]) && map[r+dx[back]][c+dy[back]] != 1) {
                    r += dx[back];
                    c += dy[back];
                } else {
                    break;
                }
            }
            
        }
        System.out.println(answer);
    }

    public static int turn(int d) {
        return (d-1)<0 ? 3 : d-1;
    }

    public static boolean checkSurround(int r, int c) {

        for(int i = 0; i < 4; i++) {
            int tx = r + dx[i];
            int ty = c + dy[i];
            if(checkInMap(tx, ty)) {
                if(map[tx][ty] == 0) return true;
            }
        }
        return false;
    }

    public static boolean checkInMap(int tx, int ty) {
        return tx >= 0 && tx < map.length && ty >= 0 && ty < map[0].length;
    }
}
