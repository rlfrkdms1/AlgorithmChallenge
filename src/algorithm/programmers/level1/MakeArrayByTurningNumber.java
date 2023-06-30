class MakeArrayByTurningNumber {
    public int[] solution(long n) {
        String number = Long.toString(n);        
        int[] answer = new int[number.length()];
        for(int i = number.length()-1; i >= 0; i--){
            answer[number.length()-i-1] = Integer.parseInt(number.substring(i,i+1));
        }
        return answer;
    }
}
