class TheNumberOfpAndyInString {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        s = s.toLowerCase();
        
        for(int i = 0; i < s.length(); i++){
            String target = s.substring(i,i+1);
            if (target.equals("p")){
                p++;
            } else if (target.equals("y")){
                y++;
            }
        }

        return p == y;
    }
}
