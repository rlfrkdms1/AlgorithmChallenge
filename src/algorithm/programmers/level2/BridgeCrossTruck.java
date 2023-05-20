import java.util.LinkedList;
import java.util.Queue;

class BridgeCrossTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight=0;

        Queue<Integer> bridge = new LinkedList<>();
        for (int j = 0; j < bridge_length; j++) {
            bridge.offer(0);
        }

        int i = 0;
        while (!bridge.isEmpty()) {

            //트럭 빼기
            bridge_weight -= bridge.peek();
            bridge.poll();

            //
            if (i<truck_weights.length && bridge_weight + truck_weights[i] <= weight) {
                bridge.offer(truck_weights[i]);
                bridge_weight += truck_weights[i];
                i++;
            } else if(i<truck_weights.length){
                bridge.offer(0);
            }

            answer++;
        }
        return answer;
    }
}
