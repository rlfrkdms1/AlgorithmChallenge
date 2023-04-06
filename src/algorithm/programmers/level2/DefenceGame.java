import java.util.*;

class DefenceGame {
    public int solution(int n, int k, int[] enemy) {
        if (enemy.length <= k) return enemy.length;
        PriorityQueue<Integer> copy = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < enemy.length; i++){
            copy.add(enemy[i]);
            n-=enemy[i];
            if(n < 0){
                if(k != 0){
                    k--;
                    int poll = copy.poll();
                    n+=poll;
                } else {
                    return i;
                }
            }
        }
        return enemy.length;
    }
    
}
