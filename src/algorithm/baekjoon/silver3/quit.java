import java.util.*;
import java.io.*;

class Main{

    static int[][] plans;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        plans = new int[n][2];
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            plans[i][0] = Integer.parseInt(input[0]);
            plans[i][1] = Integer.parseInt(input[1]);
        }
        for(int i = 0; i < n; i++) {//모든 일 수 돌아가면서 실행
            dfs(i, 0);
        }
        System.out.println(max);
    }

    public static void dfs(int index, int profit) {
        if(index >= plans.length || plans[index][0] + index > plans.length) {
            if(profit > max) max = profit;
            return; // n+1일 이상인 경우 STOP
        }
        profit += plans[index][1]; //해당 일수의 이익 저장
        for(int i = index + plans[index][0]; i < plans.length + 1; i++){
            dfs(i, profit);
        }
    }
}
