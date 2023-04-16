class HarshadNumber {
    public boolean solution(int x) {
        String number = Integer.toString(x);
        String[] numbers = number.split("");
        int sum = 0;
        for(int i = 0; i < number.length(); i++){
            sum+=Integer.parseInt(numbers[i]);
        }
        
        return x%sum == 0;
    }
}
