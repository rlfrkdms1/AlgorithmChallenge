import java.util.*;
class TableHashFunction {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1,o2)->{
            if(o1[col-1]==o2[col-1]){
                return Integer.compare(o2[0],o1[0]);
            } else {
                return Integer.compare(o1[col-1],o2[col-1]);
            }
        });
        
        boolean first = true;
        int[] s = new int[data.length];
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[0].length; j++){
                s[i] += data[i][j] % (i+1);
            }
            if(row_begin <= i+1 && row_end >= i+1){
                if(first) {
                    answer = s[i];
                    first=false;
                } else {
                    answer = answer^s[i];
                }
            }
        }
        
        
        return answer;
    }
}
