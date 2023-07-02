import java.util.*;
import java.util.stream.*;

class DivisibleArrayOfNumbers {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> number = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i]%divisor==0){
                number.add(arr[i]);
            }
        }
        if(number.size()==0) return new int[] {-1};
        Collections.sort(number);
        return number.stream().mapToInt(i->i).toArray();

    }
}
