import java.io.*;
import java.util.stream.*;
import java.util.*;

//[현대 모비스][예선]
class DeadOrAlive {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, int[]> cars = new HashMap<>();
		
		int size = Integer.parseInt(br.readLine());
		for(int i = 0; i < size; i++){
			int[] vw = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); //입력값의 속도, 내구도
			int[] target = cars.getOrDefault(vw[0], new int[] {0,0}); // 차량번호, 내구도
			if(target[1] < vw[1] || target[1] == vw[1]){//속도가 같고, 내구도가 입력 값이 더 클 경우 or 속도, 내구도가 같을 경우
				cars.put(vw[0], new int[] {i+1,vw[1]});
			} 	
		}
		
		int answer = 0;
		for(int key : cars.keySet()){
			answer+=cars.get(key)[0];
		}
		System.out.println(answer);
	}
  
}
