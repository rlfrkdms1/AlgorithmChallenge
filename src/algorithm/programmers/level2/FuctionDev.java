import java.util.*;

        /*
        나는 남은 배포일을 모두 미리 계산해서 큐에 넣어놓고 하나씩 빼면서 앞에 있는 배포일 보다 적으면 count를 늘려 answer에 넣었는데,
        for문을 돌려 배포일을 계산하면서 큐에 넣는데 앞에 보다 크면 큐를 clear하고 answer에 값넣고 다시시작
        내가 잘못한점
        1. '앞에 있는'을 잘못이해했음
        만약 90,98,99가 한 answer에 들어갈 수 있다면, 나는 98과 99가 90보다 일찍 개발되었기 때문이라고 생각했는데,
        90보다 98이, 98보다 99가 더 빨리 개발되었기 때문에 가능한것이나 마찬가지다 그러므로 이중 반복문을 사용할 필요가 없다

        2. 캐스팅
        Math.ceil을 사용하기만 하면 올림 돼서 괜찮을 줄 알았는데 이것 때문에 한참 헤맸다.
        정수 / 정수 는 답이 정수로 나오므로 올림을 사용해도 소용이 없다는 것이다.
        하마터면 이거때문에 큰일 날 뻔했다.
        따라서 정수 / (double) 정수로 캐스팅해서 사용해야한다.
        */
class FuctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> dates = new LinkedList<>();
        ArrayList<Integer> answers = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            dates.add((int) Math.ceil((100-progresses[i]) / (double)speeds[i]));
        }

        int front = 0;

        int count =0;
        while(!dates.isEmpty()){

            front = dates.poll();
            
            count++;
            while (true) {
                if (!dates.isEmpty()&&dates.peek() <= front) {
                    dates.poll();
                    count++;
                } else {
                    answers.add(count);
                    count=0;
                    break;
                }
            }
        }

        int[] answer = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        return answer;
    }
}
