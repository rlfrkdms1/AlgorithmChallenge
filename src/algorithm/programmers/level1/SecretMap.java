class SecretMap {
    int n;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        this.n = n;
        String[][] map1 = arrToMap(arr1);
        String[][] map2 = arrToMap(arr2);
        String[][] mergeMap = mergeMap(map1, map2);
        for(int i = 0; i < n; i++){
            String str = "";
            for(int j = 0; j < n; j++){
                str+=mergeMap[i][j];
            }
            answer[i]=str;
        }
        return answer;
    }
    
    public String[][] arrToMap(int[] arr) {
        String[][] map = new String[n][n];
        for(int i = 0; i < n; i++){
            String bin = Integer.toBinaryString(arr[i]);                        
            bin = padding(n - bin.length()) + bin;
            for(int j = 0; j < n; j++){
                map[i][j] = bin.substring(j,j+1);
            }
        }
        return map;
    }
    
    public String padding(int len){
        String pad = "";
        for(int i = 0; i < len; i++){
            pad += "0";
        }
        return pad;
    }
    
    public String[][] mergeMap(String[][] map1, String[][] map2){
        String[][] mergeMap = new String[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map1[i][j].equals("1") || map2[i][j].equals("1") ){
                    mergeMap[i][j] = "#";
                } else {
                    mergeMap[i][j] = " ";
                }
            }
        }
        return mergeMap;
    }
}
