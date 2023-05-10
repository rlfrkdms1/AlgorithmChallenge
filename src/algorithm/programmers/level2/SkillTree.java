import java.util.*;

class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<String, Integer> skillMap = new HashMap<>();
        for(int i = 0; i < skill.length(); i++){
            skillMap.put(skill.substring(i,i+1), i+1);
        }
        
        for(int i = 0; i < skill_trees.length; i++){
            int order = 1;
            for(int j = 0; j < skill_trees[i].length(); j++){
                String target = skill_trees[i].substring(j, j+1);
                if(skillMap.containsKey(target)){
                    if(order==skillMap.get(target)) order++;
                    else break;
                }
                if(j == skill_trees[i].length()-1){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
