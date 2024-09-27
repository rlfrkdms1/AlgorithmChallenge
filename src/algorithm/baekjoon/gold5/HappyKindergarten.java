import java.util.*;
import java.lang.*;
import java.io.*;

class HappyKindergarten {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        //차이 구하기
        Integer[] differs = new Integer[n-1];
        for(int i = 0; i < n-1; i++) {
            differs[i] = list[i+1] - list[i];
        }

        Arrays.sort(differs, Collections.reverseOrder());
        int answer = 0;
        for(int i = k-1; i < differs.length; i++) {
            answer += differs[i];
        }
        System.out.println(answer);
    }
}
