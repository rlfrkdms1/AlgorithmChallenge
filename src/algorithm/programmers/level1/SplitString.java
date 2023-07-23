class SplitString {
    public int solution(String s) {
        int answer = 0;
        
        String first = s.substring(0,1);
        int count1 = 1;
        int count2 = 0;
        boolean check = false;
        for(int i = 1; i < s.length(); i++){
            check = false;
            if(s.substring(i,i+1).equals(first)) count1++;
            else count2++;
            
            if(count1==count2){
                if(i+1 < s.length()) {
                    first = s.substring(i+1,i+2);                
                }
                answer++;
                i = i+1;
                count1 = 1;
                count2 = 0;
                if(i == s.length()-1){
                    check = false;
                } else {
                    check = true;
                }
                
            }
            
        }
        return check ? answer : answer+1;
    }
}
