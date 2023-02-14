package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ParkingFeeCalculation {

    /**
     * <문제>
     *     주차 요금 계산
     *     @param fees 주차 요금을 나타내는 정수 배열 자동차의 입/출차 내역을 나타내는 문자열 배열
     *     @param records 자동차의 입/출차 내역을 나타내는 문자열 배열
     *     @return 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 담은 정수 배열
     * </문제>
     * <문제풀이>
     *     1. inCarList -> 입차한 차들의 list이다. key : 차번호 / value : 입차 시간 (분 단위)
     *     2. parkingTime -> 차들의 누적 주차 시간이다. key : 차번호 / value : 주차 시간 (분 단위)
     *     3. records를 돌며 입차한 차라면 inCarList에 넣고, 출차한 차라면 주차시간을 계산해 parkingTime에 넣는다.
     *     4. 출차하지 않은 차라면 출차 시간은 23:59으로 설정해 주차 시간을 계산해 parkingTime에 넣는다.
     *     5. parkingTime을 key순으로 정렬한다.
     *     6. 주차 요금을 계산한다.
     *     * calculateTime : time이 "23:59"와 같은 형태로 주어지면 분으로 바꿔 반환한다.
     * </문제풀이>
     * <피드백>
     *     map을 사용한 변수명을 list라 하여 혼란을 주었다.
     *     너무 많은 변수와 컬렉션을 사용하였다. treeMap에 대해선 저번에도 피드백을 썼는데, 이번에 사용하지 않은게 아쉽다.
     *     자동완성을 사용하다보니, iter를 사용할 때 변수명이 잘못 표기 되어 오류가 났다. 자동완성에 주의할 것
     *     출차 기록이 없는 경우 출차 시간을 23:59으로 설정해야하는데 11:59으로 설정해 시간 계산에 오류가 났다. 항상 긴장하면서 계산하자.
     *     올림은 ceil인데 구글링을 해서 적용한건데도 abs를 사용했다. 정신을 차려라...
     * </피드백>
     *
     */
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inCarList = new HashMap();
        Map<String, Integer> parkingTime = new HashMap<>();
        for(int i = 0; i < records.length; i++){
            //"05:34 5961 IN"
            String[] record = records[i].split(" ");
            String time = record[0];
            String carNum = record[1];
            String inOrOut = record[2];

            if(inOrOut.equals("IN")) { //입차라면 list에 put
                int inTime = calculateTime(time);
                inCarList.put(carNum, inTime);
            } else { //출차일경우
                parkingTime.put(carNum, parkingTime.getOrDefault(carNum, 0) + (calculateTime(time) - inCarList.get(carNum)));
                System.out.println((calculateTime(time) - inCarList.get(carNum)));
                inCarList.remove(carNum);
            }
        }

        //출차 기록이 없는 경우
        if (!inCarList.isEmpty()) {
            int outTime = calculateTime("23:59");
            for (String carNum : inCarList.keySet()) {
                parkingTime.put(carNum, parkingTime.getOrDefault(carNum, 0) + (outTime - inCarList.get(carNum)));
            }
        }

        int[] answer = new int[parkingTime.size()];
        List<Integer> parkingTimeByOrders = parkingTime.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        for (int i = 0; i < answer.length; i++) {
            if (parkingTimeByOrders.get(i) <= fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i]=(int)(fees[1] + Math.ceil((parkingTimeByOrders.get(i)- fees[0])/(double)fees[2]) * fees[3]);
            }
        }
        return answer;
    }


    public int calculateTime(String time){
        int[] times = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return (times[0] * 60) + times[1];
    }


    /**
     * <다른분풀이>
     *     in이면 time에 -1을 곱하고 out이라면 time에 1을 곱해 따로 관리할 필요가 없다.
     *     treemap을 사용하여 정렬을 하지 않아도 된다.
     * </다른분풀이>
     */
    static class OtherSolution{

        public int timeToInt(String time) {
            String temp[] = time.split(":");
            return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
        }

        public int[] solution(int[] fees, String[] records) {

            TreeMap<String, Integer> map = new TreeMap<>();

            for(String record : records) {
                String temp[] = record.split(" ");
                int time = temp[2].equals("IN") ? -1 : 1;
                time *= timeToInt(temp[0]);
                map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
            }
            int idx = 0, ans[] = new int[map.size()];
            for(int time : map.values()) {
                if(time < 1) time += 1439;
                time -= fees[0];
                int cost = fees[1];
                if(time > 0)
                    cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];

                ans[idx++] = cost;
            }
            return ans;
        }
    }

}
