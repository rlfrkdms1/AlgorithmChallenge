class OXQuiz {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            String[] split = quiz[i].split(" ");
            if(split[1].equals("-")){
                if(Integer.parseInt(split[0])-Integer.parseInt(split[2])==Integer.parseInt(split[4])) {
                    answer[i] = "O";
                } else{
                    answer[i] = "X";
                }
            } else{
                if(Integer.parseInt(split[0])+Integer.parseInt(split[2])==Integer.parseInt(split[4])) {
                    answer[i] = "O";
                } else{
                    answer[i] = "X";
                }
            }
        }
        return answer;
    }
}
