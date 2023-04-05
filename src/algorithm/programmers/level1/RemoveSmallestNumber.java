import java.util.*;
import java.util.stream.*;

class RemoveSmallestNumber {
    public int[] solution(int[] arr) {
        int min = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < arr[min]) min = i;
            list.add(arr[i]);
        }
        list.remove(min);
        if(list.size()==0){
            int[] answer = {-1};
            return answer;
        } else {
            int[] answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
    
    public int[] solutionByStream(int[] arr) {
        if(arr.length == 1) return new int[] {-1};
        final int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }
}
