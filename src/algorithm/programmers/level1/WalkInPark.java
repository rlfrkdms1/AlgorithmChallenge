import java.util.*;

class WalkInPark {
  
    public int[] solution(String[] park, String[] routes) {
      
        boolean[][] map = new boolean[park.length][park[1].length()];
        int[] temp = new int[2];
        Map<String, int[]> routemap = Map.of(
            "E", new int[] {0, 1},
            "W", new int[] {0, -1},
            "S", new int[] {1, 0},
            "N", new int[] {-1, 0} 
        );
        
        //create map of park
        for (int i = 0; i < park.length; i++){
            String[] line = park[i].split("");
            for(int j = 0; j < park[1].length(); j++){
                if(line[j].equals("S")){
                    temp[0] = i;
                    temp[1] = j;    
                } else if (line[j].equals("X")){
                    continue;
                }
                map[i][j] = true;
            }
        }
        
        //search start
        for(int i = 0; i < routes.length; i++){
            String[] route = routes[i].split(" ");
            int routeValue = Integer.parseInt(route[1]);
            boolean success = true;
          
            //check obstacle 
            for(int j = 1; j <= routeValue; j++){
                int x = temp[0] + routemap.get(route[0])[0] * j;
                int y = temp[1] + routemap.get(route[0])[1] * j;
                if(x < 0 || x >= map.length || y<0 || y >= map[1].length || !map[x][y]){
                    success = false;
                    break;
                }
            }
          
            if(success){
                temp[0] += routemap.get(route[0])[0]*routeValue;
                temp[1] += routemap.get(route[0])[1]*routeValue;
            )
        }
        
        return temp;
    }
}
