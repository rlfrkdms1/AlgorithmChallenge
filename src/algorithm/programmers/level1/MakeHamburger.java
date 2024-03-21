import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder target = new StringBuilder();
        for(int i : ingredient) {
            target.append(i);
            int size = target.length();
            if(size > 3 && target.substring(size-4, size).equals("1231")) {
                target = target.replace(size-4, size, "");
                answer++;
            }
        }
        //String target = stringBuilder.toString();
        
        /*
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < target.length()-3; i++){
                if(target.substring(i,i+4).equals("1231")) {
                    target = target.replace(i, i+4, "");
                    answer++;
                    flag = true;
                    break;
                }
            }
        }
        */
        
        /*
        while(target.contains("1231")) {
            target = target.replaceFirst("1231","");
            answer++;
        }
        */
        /*
        while(true){
            int origin = target.length();
            target = target.replaceFirst("1231","");
            int targets =  target.length();
            if(origin == targets) break;
            else {
                answer++;
            }
        }*/
        
        /*
        boolean flag = true;
        while(flag){
            int index = -1;
            flag = false;
            for(int i = 0; i < ingredients.size(); i++) {
                if(ingredients.get(i) == answers[index+1]) {
                    index++;
                } else {
                    if(ingredients.get(i) == answers[0]) index = 0;
                    else index = -1;
                }
                if(index == 3) {
                    for(int j = i; j >= i-3; j--) {
                        ingredients.remove(j);
                    }
                    answer++;
                    flag = true;
                    index = -1;
                }
            }
        }
        */
        /*
        int index = -1;
        for(int i = 0; i < ingredients.size(); i++) {
            
            if(ingredients.get(i) == answers[index+1]) {
                index++;
            } else {
                if(ingredients.get(i) == answers[0]) index = 0;
                else index = -1;
            }
            if (index == 3){
                for(int j = i; j >= i-3; j--) {
                    ingredients.remove(j);
                }
                answer++;
                index = -1;
                if(i-6 < 0) i = 0;
                else i -= 6;
            }
            if(i + 1 == ingredients.size()) break;
        }
        */
        return answer;
    }
}
