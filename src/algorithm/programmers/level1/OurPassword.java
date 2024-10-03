class OurPassword {
    public String solution(String s, String skip, int index) {
        
        boolean[] isSkip = new boolean[26];
        for(int i = 0; i < skip.length(); i++) {
            isSkip[(int) skip.charAt(i) - 97] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int target = (int)s.charAt(i) - 97;
            int count = 0;
            int j = (target + 1) % 26;
            while(true) {
                if(!isSkip[j]) count++;
                if(count == index) {
                    break;
                }
                j = (j + 1) % 26;
            }
            sb.append((char) (j + 97));
        }
        return sb.toString();
    }
}
