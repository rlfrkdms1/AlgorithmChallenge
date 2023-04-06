import java.util.*;

class DefenceGame {
    /**
    1. 큐가 아닌 enemy와 길이가 같은 배열을 사용했는데, 정렬시에 아직 비어있는 것도 정렬이 되어 값이 이상해졌다. 
    2. 우선순위 큐(힙)가 아닌 list를 사용해서 Collections.sort() 사용했지만, 정렬 횟수가 너무 많아 시간초과 오답이 자꾸 떴다.
    우선순위 큐를 통해 정렬을 하지 않아도 되고 poll을 통해 삭제와 조회를 한번에 할 수 있었다. 
    **/
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
