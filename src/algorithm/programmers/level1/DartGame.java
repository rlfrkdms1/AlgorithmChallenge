class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        String[] split = dartResult.split("S|D|T|#|\\*");
        String[] split2 = dartResult.split("[0-9]");
        
        int[] numbers = new int[3];
        int index = 0;
        for(int i = 0; i < split.length; i++){
            
            if(!split[i].equals("")){
                numbers[index]=Integer.parseInt(split[i]);
                index++;
            }
            
            
        }
        
        String[] op = new String[3];
        index = 0;
        for(int i = 0; i < split2.length; i++){
            if(!split2[i].equals("")){
               op[index]=split2[i];
                index++; 
            } 
            
        }
        
        for(int i = 0; i < 3; i++){
            if(op[i].length() == 1){//SDT
                numbers[i]=sdt(numbers[i], op[i]);
            } else { // SDT + prize
                String area = op[i].substring(0,1);
                String prize= op[i].substring(1,2);
                numbers[i]=sdt(numbers[i], area);
                if(prize.equals("*")){
                    if(i != 0){
                        numbers[i-1]*=2;
                    } 
                    numbers[i]*=2; 
                }else {//#
                    numbers[i]*=-1;
                }
            }
        }
        
        for(int i = 0; i < numbers.length; i++){
            answer+=numbers[i];
        }
        return answer;
    }
    
    public int sdt(int number, String op){
        if(op.equals("S")){
            return (int)Math.pow(number, 1);
        } else if(op.equals("D")){
            return (int)Math.pow(number, 2);
        } else {
            return (int)Math.pow(number, 3);
        }
    }
}
