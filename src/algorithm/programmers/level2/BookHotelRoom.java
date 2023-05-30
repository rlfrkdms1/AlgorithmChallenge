import java.util.*;

class BookHotelRoom {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++){
            for(int j = 0; j < 2; j++){
                time[i][j] = Integer.parseInt(book_time[i][j].replaceAll(":",""));
            }
        }
        Arrays.sort(time, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int[] endTime = new int[book_time.length];
        for(int i = 0; i < book_time.length; i++){
            boolean flag = false;
            for(int j = 0; j < endTime.length; j++){
                if(endTime[j] == 0){
                    answer = j;
                    break;
                }
                
                if(endTime[j] <= time[i][0]){
                    endTime[j] = calculateTime(time[i][1]);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                endTime[answer] = calculateTime(time[i][1]);
            }
            
        }
        answer = endTime.length;
        for(int i = 0; i < endTime.length; i++){
            //System.out.println(endTime[i]);
            if(endTime[i] == 0){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public int calculateTime(int time){
        int minute = time % 100;
        if(minute >= 50){
            time += 100;
            time -= 50;
        } else {
            time += 10;
        }
        return time;
    }
}
