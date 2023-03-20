package algorithm.programmers.level2;

import java.util.Stack;

public class RemovingPairs {

    /**
     * <문제>
     *     짝지어 제거하기
     *      @param s 알파벳 소문자로 이루어진 문자열
     *      @return 짝지어 제거하기를 성공적으로 수행할 수 있는지
     * </문제>
     * <풀이>
     *     Stack에서 꺼낸 값이 넣으려는 값과 같다면 둘 다 제거, 다르다면 push
     * </풀이>
     * <피드백>
     *     원래는 solution에 있는 풀이를 사용했다.
     *     완탐이기에 문제 풀이엔 상관이 없었으나, 시간초과 실패가 문제였다.
     *     이 문제의 핵심은 queue를 쓰는 것도 아니고 완탐을 쓰는 것도 아닌 stack을 사용해야하는 문제였다.
     *     이어진 것을 삭제하기 때문에 queue보다 stack을 써야하고, 2개를 삭제하기 때문에 완탐보다 stack을 사용해야한다.
     *     예전에 2개 횟수 제한이 없던 문제를 풀었던 기억에 완탐을 사용했는데, 어쩌면 이런식의 옛 문제 복기가 마냥 좋은 것만은 아니라고 생각이 들었다.
     *     그때와 문제가 조금 달라진 만큼 풀이도 다를 수 있는데 그 틀에 사로 잡혀 다른 풀이를 생각하지 못하기 때문이다.
     * </피드백>
     */
    public int correctSolution(String s) {
        Stack<String> stack = new Stack<>();
        for(int i=0; i < s.length(); i++){
            String split = s.substring(i,i+1);
            if(!stack.isEmpty() && split.equals(stack.peek())){
                stack.pop();
            }else{
                stack.push(split);
            }
        }

        return (stack.isEmpty()) ? 1 : 0;
    }

    public int solution(String s) {
        boolean isContinued = true;
        while(isContinued){
            isContinued = false;
            for (int i = 0; i < s.length()-1; i++) {
                if (s.substring(i, i + 1).equals(s.substring(i + 1, i + 2))) {
                    s = s.substring(0, i) + s.substring(i + 2, s.length());
                    isContinued = true;
                    break;
                }
            }
        }

        return (s.length() > 0) ? 0 : 1;
    }

}
