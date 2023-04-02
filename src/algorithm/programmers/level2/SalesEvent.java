import java.util.*;

class SalesEvent {
  
  /**
  원래는 Map<String, Integer> cloneWants = new HashMap<>(wants);을
  Map<String, Integer> cloneWants = wants 와 같이 작성했었는데 얕은 복사가 되어 문제가 생겼었다. 
  생성자를 이용하거나, clone()을 이용해 객체는 항상 깊은 복사를 해줘야함을 잊지 말아야한다. 
  **/
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wants = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wants.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length-9; i++){
            Map<String, Integer> cloneWants = new HashMap<>(wants);
            
            for(int j = i; j < i+10; j++){
                if(cloneWants.containsKey(discount[j]) && 
                   cloneWants.get(discount[j])!=0){
                    cloneWants.put(discount[j],cloneWants.get(discount[j])-1);
                
                } else {
                    break;
                }
                if(j == i+9){
                    answer++;
                }
            }
        }
        return answer;
    }
}
