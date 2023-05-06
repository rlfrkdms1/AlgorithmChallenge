import java.util.*;

class PressTheKeypad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] left = {3,0};
        int[] right = {3,2};
        Map<Integer, int[]> keypad = new HashMap<>();
        int num = 1;
        for(int i = 0; i <3; i++){
            for(int j = 0; j < 3; j++){
                keypad.put(num, new int[] {i, j});
                num++;
            }
        }
        keypad.put(0, new int[] {3,1});
        for(int i = 0; i < numbers.length; i++){
            int[] target = keypad.get(numbers[i]);
            if(numbers[i]%3==1){ // 1,4,7일 때
                left = target;
                answer+="L";
            } else if (numbers[i]%3==0&&numbers[i]!=0){ // 3,6,9일 때
                right = target;
                answer+="R";
            } else { // 2,5,8,0일 때
                int dif_r = Math.abs(target[0]-right[0])+Math.abs(target[1]-right[1]);
                int dif_l = Math.abs(target[0]-left[0])+Math.abs(target[1]-left[1]);
                if(dif_r>dif_l){//left가 더 가까움
                    left = target;
                    answer+="L";
                } else if (dif_r<dif_l){//rigth가 더 가까움
                    right = target;
                    answer+="R";
                } else {//rigth와 legth의 길이가 같음
                    if(hand.equals("right")){
                        right = target;
                        answer+="R";
                    } else {
                        left = target;
                        answer+="L";
                    }
                }
            }
        }
        return answer;
    }
}
