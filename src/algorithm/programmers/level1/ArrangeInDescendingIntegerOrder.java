import java.util.*;

class ArrangeInDescendingIntegerOrder {
    public long solution(long n) {
        List<String> numbers = new ArrayList<>();
        String number = Long.toString(n);
        for(int i = 0; i < number.length(); i++){
            numbers.add(number.substring(i,i+1));
        }
        Collections.sort(numbers,Collections.reverseOrder());
        number = "";
        for(int i = 0; i < numbers.size(); i++){
            number+=numbers.get(i);
        }
        
        return Long.parseLong(number);
    }
}
