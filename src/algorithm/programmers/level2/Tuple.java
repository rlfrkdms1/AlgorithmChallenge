import java.util.*;

class Tuple {

    public int[] solution(String s) {
    
        Comparator<Integer> comparator = (s1, s2) -> s1.compareTo(s2);
        Map<Integer, List<Integer>> tuples = new TreeMap<>(comparator);
        String[] stringtuples = s.substring(2,s.length()-1).split("\\{|\\}");
        
        for(int i =0; i < stringtuples.length; i++){
            if(stringtuples[i].equals(",")) continue;
            String[] splittuple = stringtuples[i].split(",");
            List<Integer> tuple = new ArrayList<>();
            for(int j = 0; j < splittuple.length; j++){
                tuple.add(Integer.parseInt(splittuple[j]));
            }
            tuples.put(tuple.size(), tuple);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for(Integer key : tuples.keySet()){
            List<Integer> tuple = tuples.get(key);
            for(int i = 0; i < tuple.size(); i++){
                if(!answer.contains(tuple.get(i))){
                    answer.add(tuple.get(i));
                    break;
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
