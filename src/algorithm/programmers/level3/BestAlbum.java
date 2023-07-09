import java.util.*;
import java.util.stream.*;

public class BestAlbum {
  
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> total = new HashMap<>();
        Map<String, Map<Integer, Integer>> genreMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            total.put(genres[i], total.getOrDefault(genres[i],0)+plays[i]);
            Map<Integer, Integer> innermap = genreMap.getOrDefault(genres[i], new HashMap<>());
            innermap.put(i,plays[i]);
            genreMap.put(genres[i], innermap);
        }

        List<String> genrelist = new ArrayList<>(total.keySet());
        Collections.sort(genrelist, (key1, key2) -> (total.get(key2).compareTo(total.get(key1))));

        for(String key : genrelist){
            Map<Integer, Integer> innermap = genreMap.get(key);
            List<Integer> ids = new ArrayList<>(innermap.keySet());
            Collections.sort(ids, (value3, value4) -> (innermap.get(value3) == innermap.get(value4)) ? value3.compareTo(value4) : innermap.get(value4).compareTo(innermap.get(value3)));
            if(innermap.size()>=2){
                answer.add(ids.get(0));
                answer.add(ids.get(1));
            } else {
                answer.add(ids.get(0));
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }

}
