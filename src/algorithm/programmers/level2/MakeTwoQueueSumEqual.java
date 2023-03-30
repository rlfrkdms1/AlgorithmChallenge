import java.util.*;

class MakeTwoQueueSumEqual {
  
    /**
    sum을 long타입으로 해주지 않아서 계속 오류가 났었다. 
    **/
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long sum1 = 0l;
        long sum2 = 0l;
        
        Queue<Integer> list1 = new LinkedList<>();
        Queue<Integer> list2 = new LinkedList<>();
        
        for(int i = 0; i < queue1.length; i++){
            list1.add(queue1[i]);
            sum1 += queue1[i];
            list2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        while(count < queue1.length*4){
            if(sum1==sum2) return count;
            
            if(sum1<sum2){//2에서 1로 주기
                int ele = list2.poll();
                sum1 += ele;
                sum2 -= ele;
                list1.add(ele);
            } else {
                int ele = list1.poll();
                sum2 += ele;
                sum1 -= ele;
                list2.add(ele);
            }
            count++;
        }
        return -1;
    }
    
 
    
}
