import java.util.*;

class Process {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        List<Integer> prints = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            prints.add(priorities[i]);
        }
      
        while (true) {

            if(prints.get(0)< Collections.max(prints)){
                prints.add(prints.get(0));

                prints.remove(0);
               
                if (location == 0) {
                    location = prints.size()-1;
                }else location--;
            } else {
                prints.remove(0);
                if (location == 0) {
                    return answer;
                }
                else {
                    location--;
                    answer++;
                }
            }
        }
       
    }
}
