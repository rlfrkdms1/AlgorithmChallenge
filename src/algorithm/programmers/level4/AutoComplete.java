package algorithm.programmers.level4;

import java.util.Arrays;


public class AutoComplete {

    /**
     * <문제>
     *     자동 완성 - 완전 탐색 (시간 초과로 인한 오답)
     *     @param words 학습과 검색에 사용될 중복 없는 단어
     *     @return 학습된 단어들을 순서대로 찾을 때 몇 개의 문자를 입력하면 되는지
     * </문제>
     * <풀이>
     *     for문을 돌리며 target 단어를 한자리씩 잘라 startsWith로 비교해 학습된 단어를 완성시킨다.
     * </풀이>
     * <피드백>
     *     for문이 돌아가는 범위가 비효율적인 것 같다.
     *     words를 정렬 시킨 만큼 이득을 봐야하는데, 별 다른 이득을 취하지 못하는 것 같다.
     * </피드백>
     */
    public int solution(String[] words) {
        int answer = 0;

        Arrays.sort(words);

        for(int i = 0;i < words.length; i++){
            int index = 1;
            String target = words[i].substring(0,1);
            for(int j = 0; j < words.length; j++){
                if(i==j) continue;
                for(int k = index; k < words[i].length(); k++){
                    if(words[j].startsWith(target)){
                        target += words[i].substring(index,index+1);
                        index++;
                    }
                    else{
                        break;
                    }
                }
            }
            answer+=index;
        }
        return answer;
    }

    /**
     * 우연히 아래에 해설보기가 있기에 보았는데, 내가 이제껏 찾지 못한 문제에 대한 해결책이 있었다.
     * 나는 words를 sort하는 것 까진 생각했으나 탐색 범위 선정에 어려움을 겪었다.
     * 하지만 탐색 범위를 앞,뒤 두쌍으로 좁힐 수 있다.
     * 이 방법을 통해 문제를 통과했다.
     */
    public int solution2(String[] words) {
        int answer = 0;
        Arrays.sort(words);

        for (int i = 0; i < words.length; i++) {
            int index = 1;
            String target = words[i].substring(0, 1);
            for (int j = i - 1; j <= i + 1; j++) {
                if (i == j || j < 0 || j >= words.length) continue;
                for (int k = index; k < words[i].length(); k++) {
                    if (words[j].startsWith(target)) {
                        target += words[i].substring(index, index + 1);
                        index++;
                    } else {
                        break;
                    }
                }
            }
            answer += index;
        }
        return answer;
    }
}
