class Carpet {
    public int[] solution(int brown, int yellow) {
        
        int width = ((brown - 4) / 2) - 1;
        int height = 1;
 
        while (true) {
        
            if (width * height == yellow) {
                break;
            }
            width--;
            height++;
        }

        int[] answer = {width+2, height+2};
        return answer;
    }
}
