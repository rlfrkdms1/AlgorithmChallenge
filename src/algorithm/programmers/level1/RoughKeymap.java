import java.util.*;

class RoughKeymap {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> keyMap = new HashMap<>();
        for(int i = 0; i < keymap.length; i++){
            String[] split = keymap[i].split("");
            for(int j = 0; j < split.length; j++){
                if(keyMap.containsKey(split[j])){ // 이미 있는 경우
                    if(keyMap.get(split[j]) > j+1){
                        keyMap.put(split[j], j+1);
                    }
                } else {
                    keyMap.put(split[j], j+1);
                }
            }
        }
        
        for(int i = 0; i < targets.length; i++){
            String[] split = targets[i].split("");
            for(int j = 0; j < split.length; j++){
                if(!keyMap.containsKey(split[j])){
                    answer[i] = -1;
                    break;
                }
                answer[i]+=keyMap.get(split[j]);
            }
        }
        return answer;
    }
}
