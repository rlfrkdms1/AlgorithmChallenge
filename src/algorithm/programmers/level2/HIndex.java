import java.util.Arrays;
class HIndex {
    public int solution(int[] citations) {
        
        int count=0;

        for(int answer = citations.length; answer>-1; answer--){
            count = 0;

            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= answer) {
                    count++;//answer번 이상 인용된 논문 수 
                }
            }
            
            if (count >= answer) {
                return answer;
            }
            
        }

        return 0;
    }
}
