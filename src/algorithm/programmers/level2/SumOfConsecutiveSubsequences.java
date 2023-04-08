class SumOfConsecutiveSubsequences {
  
  /**
  투 포인터를 써야한다는 것을 모르고 무식하게 이중 for문을 돌렸더니, 시간초과가 떴다. 
  투 포인터의 존재는 알고 있었는데 투포인터의 대표적인 유형인 것 같다. 
  **/
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length+1};
        int end = 0;
        int sum = 0;
        
        for(int start = 0; start < sequence.length; start++){
            if(sequence[start] > k) break;
            if(sequence[start] == k) return new int[] {start, start};                

            while(sum < k && end < sequence.length){                 
                if(end - start >= answer[1]-answer[0]) break;          
                sum+= sequence[end];
                end++;  
                
                
                
            }
            if(sum == k) {
                    answer[0] = start;
                    answer[1] = end-1;
            }
            sum-=sequence[start];
        }
        return answer;
    }
}
