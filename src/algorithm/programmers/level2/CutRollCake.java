import java.util.*;
class CutRollCake {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> cheolsu = new HashMap<>(); //철수 토핑 가짓수
        Map<Integer, Integer> brother = new HashMap<>(); //동생 토핑 가짓수
        
        cheolsu.put(topping[0],1);
        for(int i = 1; i < topping.length; i++){
            brother.put(topping[i], brother.getOrDefault(topping[i],0)+1);
        }
        
        for(int i = 1; i < topping.length; i++){
            if(cheolsu.size()==brother.size()) answer++;
            cheolsu.put(topping[i], cheolsu.getOrDefault(topping[i],0)+1);
            if(brother.get(topping[i])==1) brother.remove(topping[i]);
            else brother.put(topping[i], brother.get(topping[i])-1);
        }
        return answer;
    }
}
