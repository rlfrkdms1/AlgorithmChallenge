class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int max = health;
        
        if(attacks[0][1] >= health) return -1;
        
        health -= attacks[0][1];
        
        for(int i = 1; i < attacks.length; i++) {
            int time = attacks[i][0];
            int damage = attacks[i][1];
            //회복 시간 계산
            int remain = time - attacks[i-1][0] - 1;
            health += remain*bandage[1] + (remain/bandage[0])*bandage[2];
            if(health > max) health = max;
            //피해량 계산
            health -= damage;
            if(health <= 0) return -1;
        }
        
        return health;
    }
}
