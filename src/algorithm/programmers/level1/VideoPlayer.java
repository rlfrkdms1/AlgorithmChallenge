public class VideoPlayer {

    int temp, start, end;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 동영상 재생기 기능
        // 10초 전으로 이동, 10초 후로 이동, 오프닝 건너 띄기
        // 10초 전으로 이동 : prev -> temp < 10초 ? 0분0초 : temp-10초
        // 10초 후로 이동 : next -> remain < 10 ? temp = end : temp + 10
        // 오프닝 건너 띄기 : op_start <= temp <= op_end  ? temp = op_end : temp;
        int video = Integer.parseInt(video_len.substring(0, 2)) * 60 + Integer.parseInt(video_len.substring(3, 5));
        temp = Integer.parseInt(pos.substring(0, 2)) * 60 + Integer.parseInt(pos.substring(3, 5));
        start = Integer.parseInt(op_start.substring(0, 2)) * 60 + Integer.parseInt(op_start.substring(3, 5));
        end = Integer.parseInt(op_end.substring(0, 2)) * 60 +  Integer.parseInt(op_end.substring(3, 5));
        for (String command : commands) {
            skipOpening();
            if(command.equals("prev")) {
                temp = temp < 10 ? 0 : temp - 10;
            } else {
                temp = video - temp < 10 ? video : temp + 10;
            }
            //System.out.println("temp = " + temp);
        }
        skipOpening();
        return String.format("%02d:%02d", temp/60, temp%60);
    }

    public void skipOpening() {
        if(start <= temp && temp <= end) {
            temp = end;
        }
    }

}

