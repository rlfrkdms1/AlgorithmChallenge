import java.util.*;

class UninhabitedIslandTravel {
    
    String[] maps;
    boolean[][] visit;
    int[] answer;
    
    public int[] solution(String[] maps) {
        
        this.maps = maps;
        this.visit = new boolean[maps.length][maps[0].length()];
        this.answer = new int[maps.length*maps[0].length()];
        int count = 0;
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                String target = maps[i].substring(j, j+1);
                if(!visit[i][j] && !target.equals("X")){
                    count++;
                    dfs(i*maps[0].length()+j, i, j);
                }
            }
        }
        
        if(count==0){
            return new int[] {-1};
        }
        int[] answer2 = new int[count];
        int index = 0;
        
        for(int i = 0; i < answer.length; i++){
            if(answer[i] != 0){
                answer2[index] = answer[i];
                index++;
            }
        }
        
        
        Arrays.sort(answer2);
        return answer2;
    }
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public void dfs(int start, int x, int y){
        
        answer[start] += Integer.parseInt(maps[x].substring(y,y+1));
        visit[x][y] = true;
            
        boolean flag = false;
        for(int i = 0; i < 4; i++){
            int temp_x = x + dx[i];
            int temp_y = y + dy[i];
            if(temp_x >= 0 && temp_x < maps.length && temp_y >=0 && temp_y < maps[0].length() && !maps[temp_x].substring(temp_y,temp_y+1).equals("X") && !visit[temp_x][temp_y]){
                flag = true;
                dfs(start, temp_x, temp_y);
            }
        }
        
        if(!flag){
            return;
        }
    }
}
