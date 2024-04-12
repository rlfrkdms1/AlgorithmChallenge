import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        Map<String, Integer> alphabets = Map.of("A",0,"E",1,"I",2,"O",3,"U",4);
        for(int i = 0; i < word.length(); i++) {
            String ch = word.substring(i, i+1);
            answer+= (alphabets.get(ch))*(Math.pow(5,(5-i))-1)/4+1;
        }
        return answer;
    }
}
