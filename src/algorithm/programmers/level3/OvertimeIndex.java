import java.util.*;

class OvertimeIndex {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++){
            queue.add(works[i]);
        }
        
        for(int i = 0; i < n; i++){
            int pop = queue.poll();
            if(pop == 0) return 0;
            queue.add(pop-1);
        }

        while(!queue.isEmpty()){
            answer += Math.pow(queue.poll(), 2);
        }
        return answer;
    }
}
