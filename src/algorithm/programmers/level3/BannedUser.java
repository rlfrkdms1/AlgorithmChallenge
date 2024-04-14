import java.util.*;

class Solution {
    
    String[] banned_id;
    Set<Set<String>> result = new HashSet<>();
    Map<Integer, List<String>> badIdsMap = new HashMap<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        this.banned_id = banned_id;
        //banned_id 해당하는 user_id 구분
        for(int i = 0; i < banned_id.length; i++){
            List<String> badIds = new ArrayList<>();
            for(int j = 0; j < user_id.length; j++) {
                if(banned_id[i].length()!=user_id[j].length()) continue;
                boolean banned = true;
                for(int k = 0; k < banned_id[i].length(); k++) {
                    if(banned_id[i].charAt(k) == '*') continue;
                    if(banned_id[i].charAt(k) != user_id[j].charAt(k)) {
                        banned = false;
                        break;
                    }
                }
                if(banned) {
                    badIds.add(user_id[j]);
                }
            }
            badIdsMap.put(i, badIds);
        }
        
        dfs(new HashSet<>());
        
        return result.size();
    }
    
    public void dfs(Set<String> ids) {
        if(ids.size() == banned_id.length) {
            result.add(ids);
            return;
        }
        
        List<String> targets = badIdsMap.get(ids.size());
        
        for(int i = 0; i < targets.size(); i++) {
            if(ids.contains(targets.get(i))) continue;
            ids.add(targets.get(i));
            dfs(ids);
            ids.remove(targets.get(i));
        }
        
    }
}
