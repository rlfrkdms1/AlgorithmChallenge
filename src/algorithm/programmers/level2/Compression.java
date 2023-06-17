import java.util.*;
import java.util.stream.*;

class Compression {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i <alphabet.length(); i++){
            dic.put(alphabet.substring(i,i+1), i+1);
        }
        
        for(int i = 0; i < msg.length(); i++){
            String target = msg.substring(i,i+1);
            int index = dic.get(target);
            int j = i+1;
            while(j < msg.length()){
                target = target + msg.substring(j, j+1);
                
                if(!dic.containsKey(target)){ 
                    dic.put(target, dic.size()+1); 
                    break;
                } 
                index = dic.get(target);
                j++;
                i = j-1; 
            }
            answer.add(index);
        }
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = answer.get(i);
        }
        
        return result;
    }
}
