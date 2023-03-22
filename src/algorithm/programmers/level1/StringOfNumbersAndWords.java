package algorithm.programmers.level1;

import java.util.List;

public class StringOfNumbersAndWords {

    public int solution(String s) {
        String answer = "";
        List<String> number = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            System.out.println("i = " + i);
            if (substring.chars().allMatch(Character::isDigit)) {
                answer += substring;
            } else {
                int j = i + 1;
                while (true) {
                    if (number.contains(substring)) {
                        answer += number.indexOf(substring);
                        i = j - 1;
                        break;
                    }
                    substring += s.substring(j, j + 1);
                    j++;
                }
            }
        }
        return Integer.parseInt(answer);
    }

    static class AnotherSolution {
        public int solution(String s) {
            String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            for(int i = 0; i < strArr.length; i++) {
                s = s.replaceAll(strArr[i], Integer.toString(i));
            }
            return Integer.parseInt(s);
        }
    }
}
