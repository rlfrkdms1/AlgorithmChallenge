class PaintOver {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] state = new boolean[n];
        for(int i = 0; i < section.length; i++){
            state[section[i]-1] = true;
        }
        
        for(int i = 0; i < n; i++){
            if(state[i]){
                for(int j = i; j < m+i; j++){
                    if(j >= n) break;
                    state[j] = false;
                }
                answer++;
            }
        }
        return answer;
    }
    
        public int solution2(int n, int m, int[] section) {
        int roller = section[0];
        int answer = 1;
        
        for(int i = 1; i < section.length; i++){
            if(section[i] > roller + m -1){
                answer++;
                roller = section[i];
            }
        }
        return answer;
    }
}
