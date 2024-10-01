import java.util.*;

class NumberOfConsecutiveSubsequenceSums {
    public int solution(int[] elements) {
        int[] eles = new int[elements.length + ((elements.length - 2) * (elements.length - 1) / 2)];
        for(int i = 0; i < eles.length; i++) {
            eles[i] = elements[i%elements.length];
            
        }
        int total = 0;
        for(int i = 0; i < elements.length; i++) {
           total += elements[i]; 
        }
        Set<Integer> set = new HashSet<>();
        set.add(total);
        for(int i = 1; i <= elements.length - 1; i++) {
            for(int j = 0; j < elements.length; j++) {
                int sum = 0;
                for(int k = j; k < i+j; k++) {
                    sum += eles[k];
                }
                set.add(sum);
            }            
        }
        
        return set.size() ;
    }
}
