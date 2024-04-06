class Solution {
    
    int[][] map;
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        map = arr;
        dfs(0, 0, arr.length);
        return answer;
    }
    
    public void dfs(int row, int col, int size){
        // 1. 압축할게 있는지 확인 -> 전체에서
        int start = map[row][col];
        boolean compression = true;
        
        for(int i = row; i < row+size; i++) {
            for(int j = col; j < col+size; j++) {
                if(map[i][j] != start) { // 압축을 못하는 상황
                    compression = false;
                    break;
                }
            }
        }
        
        //압축 가능 => answer score
        if(compression) {
            answer[start]++;
            return;
        } else { //압축 불가능
            dfs(row, col, size/2);
            dfs(row + size/2 , col, size/2);
            dfs(row, col + size/2, size/2);
            dfs(row + size/2, col + size/2, size/2);
        }
    }
}
