import java.util.*;
class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) return cities.length*5;
        LinkedList<String> lru = new LinkedList<>();
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            if(lru.contains(city)){
                lru.remove(city);
                lru.addFirst(city);
                answer++;
            } else {
                lru.addFirst(city);
                if(lru.size()>cacheSize){
                    lru.removeLast();
                }
                answer+=5;
            }
        }
        return answer;
    }
}
