package algorithm.baekjoon;

import java.util.*;
import java.io.*;

/**
 * <문제>
 *     과제 안내신 분 ..?
 *     input : 입력은 총 28줄로 각 제출자(학생)의 출석번호 n(1 ≤ n ≤ 30)가 한 줄에 하나씩 주어진다. 출석번호에 중복은 없다.
 *     output : 출력은 2줄이다. 1번째 줄엔 제출하지 않은 학생의 출석번호 중 가장 작은 것을 출력하고, 2번째 줄에선 그 다음 출석번호를 출력한다.
 * </문제>
 * <문제풀이>
 *     1. main에서 BufferedReader를 통해 입력을 받되 28개까지 받는다.
 *     2. 입력 받는 28개를 List에 넣는다.
 *     3. list에 1부터 30까지 있는지 확인하고 list에 없는 수는 출력한다.
 * </문제풀이>
 * <피드백>
 *     array는 contains가 되지 않아 List를 사용했는데, 다른 방식으로 array를 사용할 수 있었다.
 *     boolean[] check = new boolean[28];
 *     for(int i = 0; i<28; i++){
 *         check[Integer.parseInt(br.readLine())]=true;
 *     }
 *     java로 처음 풀어보는 백준 문제라 컴파일 오류를 많이 겪었다.
 *     1. class 명은 `Main`이어야한다.
 *     2. 프로그래머스는 언어별로 답안지가 다르게 나와 내가 무슨 언어의 답안지에 풀고 있는지 쉽게 알 수 있는데,
 *        백준은 답안지가 비어있어 내가 무슨 언어의 답안지에 풀고 있는지 알아차리기 어렵다.
 *        문제 언어를 항상 바꿔놓아야 하는 것을 잊지 말자.
 *     3. 한쪽 괄호 (`)`)를 중간에 넣으면 (`))`사이에) 안넣어지니, 마지막에 괄호를 추가해야한다. (`))` 뒤에)
 *     4. BufferedReader의 인자로 들어가는 것은 InputStreamReader이다.
 *        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
 *     5. List를 number로 선언해놓고 List.add해 오류가 났다 ㅜㅜ 정신 차려라 ㅜㅜ
 *     6. BufferedReader를 쓴다면 I/O Exception를 던져야함을 잊지 말자.
 *     7. solution 메서드를 넣지 않고, main을 작동 시켜 틀렸다. 백준은 기댓값과 출력값 등 뭐가 틀렸는지 나오지 않아서 intelliJ로 옮겨 실행해보느라 애를 먹었다. 
 * </피드백>
 */
public class WhoAssignmentNotFinish {
    public static void solution(List<Integer> number){
        for(int i=0; i<30; i++){
            if(!number.contains(i+1)){
                System.out.println(i+1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        List<Integer> number = new ArrayList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i =0; i<28; i++){
            number.add(Integer.parseInt(br.readLine()));
        }
        solution(number);
    }
}
