package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * <문제>
 *     뉴스 클러스터링
 *     input :  str1과 str2의 두 문자열
 *     output : 두 문자열의 자카드 유사도
 * </문제>
 * <풀이>
 *     1. 입력 받은 문자열을 조건에 따라 2개씩 잘라 list에 넣는다. (자른 문자열에 알파벳이 아닌 문자열이 있으면 넣지 않는다. )
 *     2. 두 list의 교집합 개수를 찾는다. 이때 두 list가 모두 empty라면 교집합은 1이다.
 *     3. 교집합 개수를 통해 합집합 개수를 구한다. (A와 B의 합집합 = A + B + A와 B의 교집합 임을 이용)
 *     4. 연산을 통해 값을 반환한다.
 * </풀이>
 * <피드백>
 *     intersection()에서 if문에 break를 주지 않아
 *     만약 set1={aa,aa}이고, set2={aa,aa,aa}라면 첫번째 탐색 (i =0)일 때 set2를 모두 0으로 초기화 시켜 intersection이 3이 되어버렸다.
 *
 *     split() 에서 if 조건문을 만족하지 않는 경우엔 배열을 채우지 않고 넘어가 null 값이 채워져 프로그래머스에서 NPE가 났다.
 *     따라서 index사용이 어려워 list를 사용했다.
 *
 *     두 list가 모두 공백인 경우 교집합이 1임을 문제에서 읽었음에도 불구하고 구현하지 않아 문제가 생겼었다.
 * </피드백>
 * target.chars().allMatch(Character::isLetter)를 사용해 string이 문자로 이루어져있는지 확인할 수 있다. 유용할 듯 하니 기억해두자
 */
public class NewsClustering {

    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> set1 = split(str1);
        List<String> set2 = split(str2);

        int intersection;
        if (set1.isEmpty() && set2.isEmpty()) {
            intersection = 1;
        } else {
            intersection = intersection(set1, set2);
        }
        int union = set1.size() + set2.size() - intersection;

        return (int) Math.floor((intersection / (double) union) * 65536);
    }

    public List<String> split(String str) {
        List<String> split = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String target = str.substring(i, i + 2);
            if (target.chars().allMatch(Character::isLetter)) {
                split.add(target);
            }
        }
        return split;
    }

    public int intersection(List<String> set1, List<String> set2) {
        int count = 0;
        for (int i = 0; i < set1.size(); i++) {
            for (int j = 0; j < set2.size(); j++) {
                if (set1.get(i).equals(set2.get(j))) {
                    set2.set(j, "0");
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
