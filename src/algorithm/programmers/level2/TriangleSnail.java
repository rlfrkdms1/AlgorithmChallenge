class Solution {
    
    int[][] map;
    int size;
    
    public enum Status { DOWN, RIGHT, LEFT}

    public int[] solution(int n) {
        size = n;
        map = new int[n][n];
        
        dfs(Status.DOWN, 0, 0, 0, 0);
        
        int[] answer = new int[ size * (size + 1) / 2];
        int index = 0;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < i+1; j++){
                answer[index++] = map[i][j];
            }
        }
        
        
        return answer;
    }
    
    public void dfs(Status status, int prev, int row, int col, int value){
        if(value == size * (size + 1) / 2) return;
        if(status == Status.DOWN) {
            if(row >= size || map[row][col] != 0) {
                dfs(Status.RIGHT, prev, row-1, col+1, value);
            } else {
                map[row][col] = ++prev;
                dfs(Status.DOWN, prev, row+1, col, ++value);
            }
        }
        if(status == Status.RIGHT) {
            if(col >= size || map[row][col] != 0) {
                dfs(Status.LEFT, prev, row-1, col-2, value);
            } else {
                map[row][col] = ++prev;
                dfs(Status.RIGHT, prev, row, col+1, ++value);
            }
        }
        if(status == Status.LEFT) {
            if(row < 0 || col < 0 || map[row][col] != 0){
                dfs(Status.DOWN, prev, row+2, col+1, value);
            } else {
                map[row][col] = ++prev;
                dfs(Status.LEFT, prev, row-1, col-1, ++value);
            }
        }
    }
}
