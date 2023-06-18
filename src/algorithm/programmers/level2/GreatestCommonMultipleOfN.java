import java.util.*;
import java.util.stream.*;

class GreatestCommonMultipleOfN {
    public int solution(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int cd = 1;
        
        for(int i = 2; i <= max; i++ ){
            int check = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[j]%i == 0){
                    check++;
                }
            }
            if(check > 1){
                cd *= i;
                for(int j = 0; j < arr.length; j++){
                    if(arr[j]%i == 0){
                        arr[j]/=i;
                    }
                }
                i--;
            } 
        }
        
        for(int i = 0; i < arr.length; i++){
            cd *= arr[i];
        }
        return cd;
    }
}
