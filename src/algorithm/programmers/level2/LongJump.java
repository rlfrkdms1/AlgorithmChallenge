class LongJump {
  
    /**
    dfs 풀이
    **/
    int n;
    long answer = 0;
    public long solution(int n) {
        this.n = n;
        dfs(1);
        dfs(2);
        
        return answer%1234567;
    }
    
    public void dfs(int temp){
      
        if(temp >= n){
            if(temp == n) answer++;
            return;
        }

        dfs(temp+1);
        dfs(temp+2);
      
    }
}
