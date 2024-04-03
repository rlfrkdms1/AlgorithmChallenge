class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i = 1; i < s.length()-2; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < s.length(); j++){
                int count = 1;
                if(j+i > s.length()) {
                    sb.append(s.substring(j, s.length()));
                    break;
                }
                String target = s.substring(j,j+i);
                j += i;
                while(j < s.length() && j+i <= s.length() && s.substring(j, j+i).equals(target)) {    
                    j+=i;
                    count++;                   
                }
                if(count == 1) sb.append(target);
                else {
                    sb.append(count);
                    sb.append(target);
                }
                j--;
            }
            answer = Math.min(answer, sb.length()); 
        }
        return answer;
    }
}
