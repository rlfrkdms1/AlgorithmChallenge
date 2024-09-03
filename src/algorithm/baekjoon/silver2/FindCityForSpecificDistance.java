import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class FindCityForSpecificDistance {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int cities = Integer.parseInt(tokenizer.nextToken());
        int roads = Integer.parseInt(tokenizer.nextToken());
        int goal = Integer.parseInt(tokenizer.nextToken());
        int start = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cities; i++) {
            map.put(i + 1, new ArrayList<>());
        }
        for (int i = 0; i < roads; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(tokenizer.nextToken());
            int target = Integer.parseInt(tokenizer.nextToken());
            map.get(origin).add(target);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[cities + 1];
        Arrays.fill(distance, -1);
        distance[start] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer target = queue.poll();
            for (Integer temp : map.get(target)) {
                if (distance[temp] == -1) {
                    distance[temp] = distance[target] + 1;
                    queue.add(temp);
                }
            }
        }
        boolean found = false;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == goal) {
                System.out.println(i);
                found = true;
            }
        }
        if (!found) System.out.println(-1);
    }
}
