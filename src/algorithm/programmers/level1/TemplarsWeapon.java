class TemplarsWeapon {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int over = 0;
        boolean[] check = new boolean[number+1];
        for(int i = 1; i <= number; i++){
            int count = 1;
            if(!check[i]){
                for(int j = 1; j <= i/2; j++){
                    if(i%j==0){
                        count++;
                    }
                    if(count > limit){
                        int next = i;
                        while(next <= number){
                            over++;
                            check[next]=true;
                            next+=next;
                        }
                        count=0;
                        break;
                    }
                }
            answer+=count;
            }

        }
        return answer+over*power;
    }
}
