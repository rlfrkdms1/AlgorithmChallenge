import java.util.*;

class FindLargeNumber {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        answer[numbers.length-1] = -1;
        Stack<Integer> big = new Stack<>();
        big.push(stack.pop());
        for(int i = numbers.length-2; i >= 0; i--) {
            int temp = stack.pop();
            while(!big.isEmpty()) {
                if(big.peek() > temp) {
                    answer[i] = big.peek();
                    break;
                }
                else {
                    big.pop();
                }
            }
            big.push(temp);
        }        
        return answer;
    }
}
