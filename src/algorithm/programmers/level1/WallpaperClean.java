class WallpaperClean {
    public int[] solution(String[] wallpaper) {
        int[] answer = {wallpaper.length+1, wallpaper[0].length()+1, 0,0};
        
        for(int i = 0; i < wallpaper.length; i++){
            String[] split = wallpaper[i].split("");
            for(int j = 0; j < split.length; j++){
                if(split[j].equals("#")){
                    if(i < answer[0]) answer[0]=i;
                    if(i > answer[2]) answer[2]=i;
                    if(j < answer[1]) answer[1]=j;
                    if(j > answer[3]) answer[3]=j;
                }
            }
        }
        answer[2]++;
        answer[3]++;
        return answer;
    }
}
