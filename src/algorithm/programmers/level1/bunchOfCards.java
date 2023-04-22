class bunchOfCards {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        boolean check;
        for(int i = 0; i < goal.length; i++){
            check = false;
            if(idx1 < cards1.length && cards1[idx1].equals(goal[i])){
                check = true;
                idx1++;
            } else if (idx2 < cards2.length && cards2[idx2].equals(goal[i])){
                check = true;
                idx2++;
            }
            if(!check) return "No";
        }
        return "Yes";
    }
}
