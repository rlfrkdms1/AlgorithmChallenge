package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatRoom {

    /**
     * <문제>
     *     오픈채팅방
     *     @param record [Enter/Leave][유저 아이디][닉네임] 형태의 문자열이 담긴 배열
     *     @return 최종적으로 방을 개설한 사람이 보게 되는 메시지의 문자열 배열 형태
     * </문제>
     * <문제풀이>
     *     1. access : [id][Enter/Leave] 2중 array
     *     2. nicknameMap : [id][nickname] 최종 닉네임
     *     3. 각각의 array, map에 알맞는 값 넣기
     *        leave인 경우엔 닉네임이 표시되지 않으니 참고,
     *        change는 change에 상관없이 put을 통해 닉네임 update,
     *        Enter도 put을 통해 닉네임 update
     *     4. change인 경우를 제외하고 출력
     * </문제풀이>
     * <피드백>
     *     User 클래스를 만들어 id와 nickname을 관리하면 어떨까 ?  => map<String, user>
     *     처음에 input을 제대로 읽지 않아 input형태가 항상 Enter uid1234 Muzi와 같이 닉네임도 붙는 줄 알았다.
     *     항상 문제를 꼼꼼히 읽어볼 것
     * </피드백>
     */
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        String[][] access = new String[record.length][2];
        Map<String, String> nicknameMap = new HashMap<>();

        //Enter uid1234 Muzi
        for (int i = 0; i < record.length; i++) {
            String[] splitRecord = record[i].split(" ");
            access[i][0] = splitRecord[1];
            access[i][1] = splitRecord[0];

            //Leave의 경우 닉네임 표시를 하지 않음
            //Leave uid1234
            if (splitRecord.length == 3) {
                nicknameMap.put(splitRecord[1], splitRecord[2]);
            }

        }

        for (int i = 0; i < access.length; i++) {
            if (!access[i][1].equals("Change")) {
                answer.add(nicknameMap.get(access[i][0]) + "님이 " + accessPrint(access[i][1]));
            }

        }

        return answer.stream().toArray(String[]::new);
    }

    public String accessPrint(String EnterOrLeave) {
        if (EnterOrLeave.equals("Enter")) {
            return "들어왔습니다.";
        }
        if (EnterOrLeave.equals("Leave")) {
            return "나갔습니다.";
        }
        return "";
    }

}
