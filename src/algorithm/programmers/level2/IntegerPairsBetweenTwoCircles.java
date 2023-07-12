class IntegerPairsBetweenTwoCircles {
    
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(long i = 1; i <=r2; i++){
            long y1 = (long)Math.floor(Math.sqrt((long)r2*r2-i*i));
            long y2 = (long)Math.ceil(Math.sqrt((long)r1*r1-i*i));
            answer+=(y1-y2+1);
        }
        
        return answer*4;
    }
    
}
