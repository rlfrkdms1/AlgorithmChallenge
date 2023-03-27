import java.util.*;
import java.util.stream.*;

class RecieveReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, User> users = new LinkedHashMap<>();
        for(int i = 0; i < id_list.length; i++){
            users.put(id_list[i], new User(id_list[i]));
        }
        
        for(int i = 0; i < report.length; i++){
            String[] splitReport = report[i].split(" ");
            String reporter = splitReport[0];
            String target = splitReport[1];
            users.get(reporter).getReporting().add(target);
            users.get(target).getReported().add(reporter);
        }
        
        for(String keyId : users.keySet()){
            Set<String> reporteds = users.get(keyId).getReported();
            if( reporteds.size() >= k){
                for(String reciever : reporteds){
                    users.get(reciever).recievMail();
                }
            }
        }
        
        int j = 0;
        for(String keyId : users.keySet()){
            answer[j] = users.get(keyId).getMailCount();
            j++;
        }
        return answer;
    }
}

class User {
    private String id;
    private Set<String> reporting = new HashSet<>();
    private Set<String> reported = new HashSet<>();
    private int mailCount;
    
    public User(String id){
        this.id = id;
        mailCount = 0;
    }
    
    public Set<String> getReporting(){
        return reporting;
    }
    
    public int getMailCount(){
        return mailCount;
    }
    
    public Set<String> getReported(){
        return reported;
    }
    
    public void recievMail(){
        mailCount++;
    }
}

class AnotherSolution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}
