import java.util.*;
class SortStringAsIWant {
    public String[] solution(String[] strings, int n) {
        TreeMap<String, List<String>> map = new TreeMap<>();
        for(int i = 0; i < strings.length; i++){
            String key = strings[i].substring(n,n+1);
            List<String> target = map.getOrDefault(key, new ArrayList<String>());
            target.add(strings[i]);
            map.put(key, target);
        }
        
        String[] answer = new String[strings.length];
        int index = 0;
        for(String key : map.keySet()){
            List<String> target = map.get(key);
            Collections.sort(target);
            for(int i = 0; i <target.size(); i++){
                answer[index] = target.get(i);
                index++;
            } 
        }
        return answer;
    }
}
