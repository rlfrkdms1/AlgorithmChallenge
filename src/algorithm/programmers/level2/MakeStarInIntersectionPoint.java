import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        Set<long[]> inters = new HashSet<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        for(int i = 0; i < line.length; i++){
            int[] l1 = line[i];
            for(int j = i+1; j < line.length; j++){
                int[] l2 = line[j];
                long divide = (long)l1[0]*(long)l2[1] - (long)l1[1]*(long)l2[0];
                long dividedX = (long)l1[1]*(long)l2[2] - (long)l1[2]*(long)l2[1];
                long dividedY = (long)l1[2]*(long)l2[0] - (long)l1[0]*(long)l2[2];
                if(divide == 0 || dividedX % divide != 0 || dividedY % divide != 0) continue;
                long x = dividedX / divide;
                long y = dividedY / divide;
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
                inters.add(new long[]{x,y});
            }
        }
        
        String[][] map = new String[(int)(maxY-minY+1)][(int)(maxX-minX+1)];
        
        for(String[] thing : map) {
            Arrays.fill(thing, ".");
        }   
        
        for(long[] ele : inters) {
            map[(int)(ele[1] - minY)][(int)(ele[0] - minX)] = "*";
        }
        
        String[] answer = new String[map.length];

        for(int i = map.length-1; i >= 0; i--){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < map[0].length; j++){
                sb.append(map[i][j]);
            }
            answer[map.length - i - 1] = sb.toString();
        }
        
        
        return answer;
    }
}
