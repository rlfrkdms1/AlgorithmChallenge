import java.util.*;
import java.util.stream.*;

/**
split(".")을 하면 빈 문자열이 나온다. "."을 정규식으로 인식해서 그렇다. 그래서 .으로 split하려면 꼭 \\를 붙여주자
**/

class PersonalInformationCollectionValidityPeriod {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int[] todays = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> category = new HashMap<>();
        for(String term : terms){
            String[] split = term.split(" ");
            category.put(split[0], Integer.parseInt(split[1]));
        }
        
        for(int i = 0; i < privacies.length; i++){
            String[] split = privacies[i].split(" ");
            int[] date = Arrays.stream(split[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
                        
            date[0]+= category.get(split[1])/12;
            date[1]+= category.get(split[1])%12;
            date[2]--;
                
            if(date[1]>12) {
                date[1]-=12;
                date[0]++;
            }
            
            if(date[2]<1){
                date[2] = 28;
                date[1]--;
            }
            
            if(date[0]<todays[0]) answer.add(i+1);
            else if (date[0]==todays[0]&&date[1]<todays[1]) answer.add(i+1);
            else if (date[0]==todays[0]&&date[1]==todays[1]&&date[2]<todays[2]) answer.add(i+1);
        }
        return answer.stream().mapToInt(i->i).toArray();
        }
    }
