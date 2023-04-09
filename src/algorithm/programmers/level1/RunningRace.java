import java.util.*;

class RunningRace {

  /**
  처음엔 list의 indexOf를 통해 문제를 해결했더니 시간초과가 떴다. 아무래도 indexof를 사용하면 전체를 다 돌아야 하니 시간이 많이 걸릴 수 밖에 없다. 
  그래서 players의 이름이 중복되지 않는 다는 점과 조회가 빨라야한다는 점을 빗대어 map을 사용해 array와 동기화 하는 방식을 사용했다. 
  map만을 이용해서 문제를 해결한 것이 아니라 map과 array를 같이 사용했다는 점이 기억해야할 중요한 부분인 것 같다. 
  **/
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++){
            int index = map.get(callings[i]);
            String target = players[index-1];
            //array 업데이트
            players[index-1] = callings[i];
            players[index] = target;
            //map 업데이트
            map.put(callings[i], index-1);
            map.put(target, index);
        }
        return players;
    }
    
}
