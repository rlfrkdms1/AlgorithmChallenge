import java.util.Stack;

public class CorrectParentheses {
    public static void main(String[] args) {
        String s = ")()(";
        boolean answer = true;

        if (s.length() % 2 != 0) {
            answer = false;
        }

        Stack<Character> store = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                store.push(s.charAt(i));
            } else if(s.charAt(i) == ')'){
                if(store.empty()){
                    answer = false;
                    break;
                }else {
                    store.pop();
                }
            }
        }

        if (!store.empty()) {
            answer = false;
        }

        System.out.println("answer = " + answer);


    }
}
