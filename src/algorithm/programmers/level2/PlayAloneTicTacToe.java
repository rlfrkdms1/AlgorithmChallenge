class PlayAloneTicTacToe {
    public int solution(String[] board) {
     
        int cnt_o = 0;
        int cnt_x = 0;
        
        boolean[][] omap = new boolean[3][3];
        boolean[][] xmap = new boolean[3][3];
        
        for(int i = 0; i < board.length; i++){
            String[] row = board[i].split("");
            for(int j = 0; j < row.length; j++){
                if(row[j].equals("O")){
                    cnt_o++;
                    omap[i][j] = true;
                } else if (row[j].equals("X")){
                    cnt_x++;
                    xmap[i][j] = true;
                } 
            }
        }
        
        //o의 개수는 항상 x의 개수 보다 많거나 같아야 한다.
        //o의 개수와 x의 개수 차이는 항상 1이다. 
        if(cnt_x > cnt_o || cnt_o-cnt_x > 1) return 0; 
        
        boolean ocomplete = checkmap(omap);
        boolean xcomplete = checkmap(xmap);
        
        if(ocomplete && xcomplete) return 0;
        
        if(ocomplete){//o가 완성한 경우
            return cnt_o-cnt_x == 1 ? 1 : 0; //o가 무조건 x보다 하나 더 많아야 한다.
        }
        if(xcomplete){//x가 완성한 경우
            return cnt_x == cnt_o ? 1 : 0; //o와 x의 수는 같아야 한다. 
        }
        
        return 1;
    }
    
    public boolean checkmap(boolean[][] map){
        boolean rowresult;
        boolean colresult;

        for(int i = 0; i < 3; i++){ 
            rowresult = true;
            colresult = true;
            for(int j = 0; j < 3; j++){
                if(!map[i][j]){
                    rowresult=false;
                }
                if(!map[j][i]) colresult = false;
            }
            if(rowresult||colresult) return true;
        }
        if(map[0][0] && map[1][1] && map[2][2]) return true;
        if(map[0][2] && map[1][1] && map[2][0]) return true;
        
        return false;
    }
    
}
