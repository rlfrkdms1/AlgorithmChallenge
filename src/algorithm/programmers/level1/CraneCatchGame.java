import java.util.*;

class CraneCatchGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> doll = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            doll.add(new Stack<Integer>());
        }
        for(int i = board.length-1; i >= 0; i--){
            for(int j = 0; j < board.length; j++){
                if(board[i][j]!=0){
                    doll.get(j).push(board[i][j]);
                }
            }
        }
        Stack<Integer> basket = new Stack<>();
        for(int i = 0; i < moves.length; i++){
            Stack<Integer> target = doll.get(moves[i]-1);
            if(!target.empty()){//크레인을 내렸는데 인형이 없는 경우 제외                  
                int pop = target.pop();
                if(!basket.empty()){//바구니에 인형이 담겼을 경우 -> 위에꺼 꺼내서 같으면 없애기
                    if(pop == basket.peek()){
                        basket.pop();
                        answer+=2;
                    } else {
                        basket.push(pop);

                    }
                } else {
                    basket.push(pop);                        

                }
            }
        }
        return answer;
    }
}
