class CaesarCipher {
    public String solution(String s, int n) {
        String answer = "";
        for(int i =0; i < s.length(); i++){
            int ascii = (int)s.charAt(i);
            if(ascii == 32) {
                answer+= (char)(ascii);
            } else if((ascii<=90 && ascii+n > 90) || ascii+n > 122) {
                answer+= (char)(ascii-26+n);
            } else {
                answer+= (char)(ascii+n);
            }

        }
        return answer;
    }
}
