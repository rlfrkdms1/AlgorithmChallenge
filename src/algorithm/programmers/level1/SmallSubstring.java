package algorithm.programmers.level1;

public class SmallSubstring {
    /**
     * 크기가 작은 부분문자열
     * @param t 숫자로 이루어진 문자열
     * @param p 숫자로 이루어진 문자열
     * @return t에서 p와 길이가 같은 부분문자열 중에서, 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수
     * 처음엔 int형으로 형변환을 했는데 답을 제출하니 일부 테케에서 런타임 에러가 떴다.
     * 알고보니 문제의 조건에서 p의 길이가 1이상 18이하여서 p의 길이가 18이라면 p는 int형으로 형변환이 되지 않아 에러가 난 것이었다.
     * substring을 쓸 때 런타임에러가 잘 나서 그 문제인줄 알고 한참 생각했는데, 다른 부분이었다.
     * 시야를 넓힐 필요가 있다고 생각했다. 
     */
    public int solution(String t, String p) {
        int answer = 0;


        long target = Long.parseLong(p);
        for (int i = 0; i < (t.length() - p.length() + 1); i++) {
            if (target >= Long.parseLong(t.substring(i, i + p.length()))) {
                answer++;
            }
        }
        return answer;
    }

    /* 처음에 생각한 풀이
    처음엔 배열에 t를 잘라 넣었다가 하나씩 꺼내면서 비교하려고 했지만 굳이 배열을 만들필요가 없었다.
    //1. substring을 저장할 배열 생성, 이때 배열의 길이는 t의 길이 - p의 길이 + 1
            int[] substrings = new int[t.length() - p.length() + 1];
            //2. p의 길이만큼 t를 잘라 저장, 이때 자른 t는 int형으로 변환 후 저장
            for (int i = 0; i < substrings.length; i++) {
                substrings[i] = Integer.parseInt(t.substring(i, i + p.length()));
            }

            //3.크기 비교를 위해 p int형으로 형변환
            int intP = Integer.parseInt(p);

            //4. 비교 후 횟수 answer에 추가
            for (int i = 0; i < substrings.length; i++) {
                if (intP >= substrings[i]) {
                    answer++;
                }
            }*/

}
