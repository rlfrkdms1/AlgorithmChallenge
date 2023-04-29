class TernaryFlip {
    public int solution(int n) {
        String reverse = "";
        String three = Integer.toString(n, 3);

        for(int i = three.length(); i >= 1; i--){
            reverse += three.substring(i-1, i);
        }        

        return Integer.parseInt(reverse,3);
    }
}
