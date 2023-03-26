import java.util.*;

class EnglishWordChain {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        List<String> word = new ArrayList<>();
        word.add(words[0]);
        for(int i = 1; i < words.length; i++){
            if(!word.get(i-1).endsWith(words[i].substring(0,1))||word.contains(words[i])){
                answer = new int[]{((i+1)%n == 0) ? n : (i+1)%n, (int) Math.ceil((i+1)/(double)n)};
                return answer;
            } 
            word.add(words[i]);
        }
        return answer;
    }
}
