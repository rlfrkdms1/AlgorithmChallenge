package Programmers.level1;

public class YearOf2016 {

    /**
     * @param a 월 (month)
     * @param b 일 (day)
     * @return
     */
    public String solution(int a, int b) {
        String answer = "";

        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"}; //주의점 : 0일이 아닌 1일이 금요일이므로 FRI부터 시작하면 안됨

        int total_days = 0;

        for (int i = 0; i < (a-1); i++) {
            total_days += months[i];
        }
        total_days += b;
        answer = day[total_days % 7];
        return answer;
    }
}
