
import java.util.*;

class TravelRoute {

    List<String> answers = new ArrayList<>();
    Map<String, List<String>> ticks = new HashMap<>();
    int answerSize;

    public String[] solution(String[][] tickets) {

        answerSize = tickets.length + 1;
        for (String[] ticket : tickets) {
            if (ticks.containsKey(ticket[0])) {
                ticks.get(ticket[0]).add(ticket[1]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(ticket[1]);
                ticks.put(ticket[0], list);
            }
        }

        dfs("ICN", "ICN");

        Collections.sort(answers);
        return answers.get(0).split(",");
    }

    public void dfs(String answer, String temp) {
        if (answer.length() == (answerSize * 3) + answerSize - 1) {
            answers.add(answer);
            return;
        }
        
        List<String> goals = ticks.get(temp);
        
        if(goals == null) return;

        for (int i = 0; i < goals.size(); i++) {
            String goal = goals.get(0);
            goals.remove(goal);
            dfs(answer + "," + goal, goal);
            goals.add(goal);
        }

    }
}
