class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++) {
            answer[i] = followed(places[i]);
        }
        return answer;
    }
    
    //distance 1
    int[] dx1 = {0, -1, 0, 1};
    int[] dy1 = {-1, 0, 1, 0};
    
    //distance 2 (cross)
    int[] dx2 = {-1, -1, 1, 1};
    int[] dy2 = {-1 ,1, 1, -1};
    
    //partition of 2
    int[][] px2 = {{-1,0},{-1,0},{0,1},{0,1}};
    int[][] py2 = {{0,-1},{0,1},{1,0},{-1,0}};
    
    //distance 2 (align)
    int[] dx3 = {0, -2, 0, 2};
    int[] dy3 = {-2, 0, 2, 0};
    
    //partition of 3
    int[] px3 = {0,-1,0,1};
    int[] py3 = {-1,0,1,0};
    
    public int followed(String[] place) {
        for(int i = 0; i < place.length; i++){
            String line = place[i];
            for(int j = 0; j < line.length(); j++){
                char target = line.charAt(j);
                if(target == 'P') {
                    int tx, ty;
                    for(int k = 0; k < 4; k++){
                        tx = i + dx1[k];
                        ty = j + dy1[k];
                        if(inBoundary(tx, ty) && place[tx].charAt(ty) == 'P') {
                            return 0;
                        }
                    }
                    
                    for(int k = 0; k < 4; k++){
                        tx = i + dx2[k];
                        ty = j + dy2[k];
                        if(inBoundary(tx, ty) && place[tx].charAt(ty) == 'P') {
                            if(place[i + px2[k][0]].charAt(j+py2[k][0]) != 'X' || place[i + px2[k][1]].charAt(j+py2[k][1]) != 'X') {
                                return 0;
                            }
                         }
                     }    
                     
                     for(int k = 0; k < 4; k++){
                         tx = i + dx3[k];
                         ty = j + dy3[k];
                         if(inBoundary(tx, ty) && place[tx].charAt(ty) == 'P') {
                             if(place[i + px3[k]].charAt(j+py3[k]) != 'X') {
                                 return 0;
                             }
                         }
                     }   
                }
            }
        }
        return 1;
    }
    
    public boolean inBoundary(int x, int y){
        if(x < 0 || x > 4 || y < 0 || y > 4) return false;
        return true;
    }
}
