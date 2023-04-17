class MakeWeirdCharacters {
    public String solution(String s) {
        String answer = "";
        String[] split = s.toLowerCase().split("");
        
        int partindex = 0;
        int index = 0;
        while(true){
            while(true){
                
                if(split[index].equals(" ")) {
                    answer+= " ";
                    index++;
                    break;
                };
                if(partindex % 2 == 0){
                    answer+=split[index].toUpperCase();
                }else {
                    answer+=split[index];
                }
                partindex++;
                index++;
                if(index == s.length()) break;
            }
            partindex=0;
            if(index == s.length()) break;
        }
        
        return answer;
    }
}
