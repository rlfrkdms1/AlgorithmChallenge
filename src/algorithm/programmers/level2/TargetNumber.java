class TargetNumber {
    int answer, target;
    int[] numbers;

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        
        dfs(numbers[0]*1, 0, 0);
        dfs(numbers[0]*-1, 0, 0);
        
        return answer;
    }
    
    public void dfs(int number, int temp, int index){
        temp += number;
        if(index == numbers.length-1){
            if(temp == target){
                answer++;
            }
            return;
        }
        index++;
        dfs(numbers[index]*1, temp, index);
        dfs(numbers[index]*-1, temp, index);
    }
    
    
}
