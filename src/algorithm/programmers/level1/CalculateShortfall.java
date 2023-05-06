class CalculateShortfall {
    public long solution(int price, int money, int count) {
        long cost = 0;
        for(int i = 0; i < count; i++){
            cost+=price*(i+1);
        }
        
        return cost>money ? cost-money : 0;
    }
}
