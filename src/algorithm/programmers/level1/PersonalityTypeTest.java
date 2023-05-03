import java.util.*;

class PersonalityTypeTest {
    
    Map<String, Integer> score = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] type = {"R","T","C","F","J","M","A","N"};
        for(int i = 0; i < type.length; i++){
            score.put(type[i], 0);
        }
        
        for(int i = 0; i < survey.length; i++){
            if(choices[i] == 4) continue;
            String[] sur = survey[i].split("");
            if(choices[i] > 4) {//동의
                score.put(sur[1], score.get(sur[1])+choices[i]-4);
            } else {
                score.put(sur[1], score.get(sur[1])+choices[i]-4);
            }
        }
        for(int i = 0; i < type.length; i+=2){
            answer+=decide(type[i],type[i+1]);
        }
   
        return answer;
    }
    
    public String decide(String type1, String type2){
        if(score.get(type1)==score.get(type2)) return type1;
        return score.get(type1)>score.get(type2) ? type1 : type2;
    }
}
