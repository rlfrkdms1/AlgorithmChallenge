import java.util.*;

/* TLE */
class FindTheLargestNumberBehind {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        for(int i = 0; i < numbers.length; i++){
            int target = numbers[i];
            for(int j = i+1; j < numbers.length; j++){
                if(target<numbers[j]){
                    answer[i]=numbers[j];
                    break;
                }
            }
        }
        return answer;
    }

    /*
    그 뒤에 있는 number의 answer에 있는 수를 참고 하는 방법
    */
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        for(int i = numbers.length-1; i >= 0; i--){
            int target = numbers[i];
            for(int j = i+1; j < numbers.length; j++){
                if(target<numbers[j]){
                    answer[i]=numbers[j];
                    break;
                } else {
                    if(answer[j]==-1){
                        answer[i] = -1;
                        break;
                    }
                    if(target==numbers[j]){
                        answer[i]=answer[j];
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
