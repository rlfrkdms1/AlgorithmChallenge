import java.util.*;

class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < operations.length; i++){
            
            String[] split = operations[i].split(" ");
            String operation = split[0];
            int data = Integer.parseInt(split[1]);
            
            if(operation.equals("D")){
                if(map.isEmpty()) continue;
                int key = data == 1 ? map.lastKey() : map.firstKey();
                int value = map.get(key);
                if(value > 1){
                        map.put(key, value-1);
                } else {
                        map.remove(key);
                }  
            } else{
                map.put(data, map.getOrDefault(data, 0)+1);
            }
        }
        
        if(map.isEmpty()){
            return new int[] {0,0};
        }
        return new int[] {map.lastKey(), map.firstKey()};
    }
}
