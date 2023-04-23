class RecommandNewI {
    public String solution(String new_id) {
        
        //1단계
        new_id = new_id.toLowerCase();
        
        //2단계
        String answer = "";
        for(int i = 0; i < new_id.length(); i++){
            String c = new_id.substring(i,i+1);
            if(!c.matches("[a-z0-9\\-_.]")) continue;
            answer+=c;
        }
        
        //3단계
        answer = answer.replaceAll("\\.{2,}",".");
        
        if(answer.startsWith(".")) answer = answer.substring(1, answer.length());
        if(answer.endsWith(".")) answer = answer.substring(0, answer.length()-1);
        
        //5단계
        if(answer.length() == 0) answer="a";
        
        //6단계
        if(answer.length() > 15){
            answer = answer.substring(0, 15);
            if(answer.endsWith(".")){
                answer = answer.substring(0,14);
            }
        }
        
        //7단계
        if(answer.length() < 3){
            String plus = answer.substring(answer.length()-1, answer.length());
            while(answer.length() <=2){
                answer+=plus;
            }
        }

        return answer;
    }
}
