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
}
