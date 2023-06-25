import java.util.*;

class WorkOnPlans {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Map<Integer, String> startname = new TreeMap<>();
        Map<String, Integer> nameplaytime = new HashMap<>();
        Stack<String> waitings = new Stack<>();
        
        for(int i = 0; i < plans.length; i++){
            int start = Integer.parseInt(plans[i][1].replace(":",""));
            startname.put(start, plans[i][0]);
            nameplaytime.put(plans[i][0], Integer.parseInt(plans[i][2]));
        }
        
        
        int i = 0;
        int prestart = -1;
        int preplaytime = 0;
        for(int key : startname.keySet()){
            if(prestart != -1){
                int remain = minustime(key, prestart);
                if(remain == preplaytime){
                    answer[i] = startname.get(prestart);
                    i++;
                } else if (remain < preplaytime){
                    String prename = startname.get(prestart);
                    nameplaytime.put(prename, preplaytime-remain);
                    waitings.push(prename);
                } else {
                    remain-=preplaytime;
                    answer[i]=startname.get(prestart);
                    i++;
                    while(!waitings.isEmpty()&&remain>0){
                        String wait = waitings.peek();
                        int waitplaytime = nameplaytime.get(wait);
                        if(waitplaytime==remain){
                            answer[i]=wait;
                            i++;
                            waitings.pop();
                            break;
                        } else if (waitplaytime > remain){
                            nameplaytime.put(wait, waitplaytime - remain);
                            break;
                        } else {
                            remain -= waitplaytime;
                            answer[i] = wait;
                            i++;
                            waitings.pop();
                        }
                    }
                }
                
            }
            prestart = key;
            preplaytime = nameplaytime.get(startname.get(key));
        }
        answer[i]=startname.get(prestart);
        i++;
        while(!waitings.isEmpty()){
            answer[i] = waitings.pop();
            i++;
        }
        
        return answer;
    }
    
    public int minustime(int big, int small){
        return ((big/100*60)+big%100)-((small/100*60)+small%100);
    }
}
