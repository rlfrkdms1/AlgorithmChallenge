import java.util.*;

class MakeLargeNumber {
    
    String answer;
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++) {
            while(!stack.isEmpty()) {
                if(number.charAt(i) > stack.peek() && k != 0) {
                    stack.pop();
                    k--;
                } else {
                    break;
                }
            }
            stack.push(number.charAt(i));
        }
        for(int i = 0; i < k; i++) stack.pop();
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
