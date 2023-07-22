import java.util.*;

class ArrangingStringInDescendingOrder {
    public String solution(String s) {
        String answer = "";
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            strings.add(s.substring(i,i+1));
        }
        Collections.sort(strings, Comparator.reverseOrder());
        for(int i = 0; i < strings.size(); i++){
            answer+=strings.get(i);
        }
        return answer;
    }
}
