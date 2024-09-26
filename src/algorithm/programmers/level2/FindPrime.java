import java.util.*;

class FindPrime {
    
    boolean[] prime;
    Set<Integer> perm = new HashSet<>();
    Integer[] list;
    boolean[] visited;
    public int solution(String numbers) {
        
        String[] arr = numbers.split("");
        
        list = new Integer[numbers.length()];
        for(int i = 0; i < arr.length; i++) {
            list[i] = Integer.parseInt(arr[i]);
        }
        
        visited = new boolean[numbers.length()];
        Arrays.sort(list, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int number : list) {
            sb.append(number);
        }
        int limit = Integer.parseInt(sb.toString());
        
        prime = new boolean[limit+1];
        Arrays.fill(prime, true);
        fillPrimeArray(); // 소수 맵 완성
        
        int answer = 0;
        for(int i = 0; i < numbers.length(); i++) {
            if(list[i] != 0 && list[i] != 1) {
                perm.add(list[i]);
            }
        }
        for(int i = 1; i < numbers.length(); i++) {
            perm(0, 0, i+1);
        }
        
        for(int number : perm) {
            if(prime[number]) {
                //System.out.println(number);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void perm(int depth, int number, int max) {
        if(depth == max) {
            if(number == 0 || number == 1) return;
            perm.add(number);
            return;
        }
        for(int i = 0; i < list.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int temp = (int)Math.pow(10, max - depth - 1) * list[i];
                perm(depth+1, number+temp, max);
                visited[i] = false;
            }
        }
    }
    
    public void fillPrimeArray() {
        for(int i = 2; i*i <= prime.length; i++) {
            if(prime[i]) { // prime 이라면 ?
                for(int j = i*i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
