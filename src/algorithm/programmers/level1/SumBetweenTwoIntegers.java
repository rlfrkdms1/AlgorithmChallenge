class SumBetweenTwoIntegers {
    public long solution(int a, int b) {
        int start, end;
        if(a < b){
            start = a;
            end = b;
        } else {
            start = b;
            end = a;
        }
        long answer=0;
        for(int i = start; i <= end; i++){
            answer+=i;
        }
        return answer;
    }
}
