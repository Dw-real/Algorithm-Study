import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0]; // 기본 시간
        int basicFare = fees[1]; // 기본 요금
        int unitTime = fees[2]; // 단위 시간
        int unitFare = fees[3]; // 단위 요금
        
        HashMap<Integer, Integer> cars = new HashMap<>(); // 자동차별 이용 시간 및 금액
        HashMap<Integer, String> inOut = new HashMap<>(); // 출입 관리

        for (int i = 0; i < records.length; i++) {
            String[] str = records[i].split(" ");
            int carNum = Integer.parseInt(str[1]); // 차량 번호
            if (inOut.containsKey(carNum)) { // 들어왔던 차량인 경우
                int prevTime = cars.getOrDefault(carNum, 0);
                String inTime = inOut.get(carNum); // 입차 시간
                int time = getTimeOfUse(inTime, str[0]);
                cars.put(carNum, prevTime + time);
                inOut.remove(carNum); // 출차 후에는 기록에서 제거
            } else {
                inOut.put(carNum, str[0]);
            }
        }

        // 아직 출차되지 않은 차량 처리
        for (Map.Entry<Integer, String> entry : inOut.entrySet()) {
            int carNum = entry.getKey();
            int prevTime = cars.getOrDefault(carNum, 0);
            String inTime = entry.getValue();
            int time = getTimeOfUse(inTime, "23:59");
            cars.put(carNum, prevTime + time);
        }

        // 요금 계산
        for (Map.Entry<Integer, Integer> entry : cars.entrySet()) {
            int carNum = entry.getKey();
            int time = entry.getValue();

            getPrice(cars, carNum, time, basicTime, basicFare, unitTime, unitFare);
        }

        // 결과 배열 생성
        int[] answer = new int[cars.size()];
        List<Integer> list = new ArrayList<>(cars.keySet());
        list.sort(Comparator.naturalOrder()); // 자동차의 번호가 작은 순으로 출력하기 위한 sort
        for (int i = 0; i < answer.length; i++) {
            answer[i] = cars.get(list.get(i));
        }

        return answer;
    }

    public void getPrice(HashMap<Integer, Integer> cars, int carNum, int time, int basicTime, int basicFare,
                         int unitTime, int unitFare) {
        if (time <= basicTime) {
            cars.put(carNum, basicFare);
        } else {
            int overTime = time - basicTime; // 초과 시간 계산
            int units = (int) Math.ceil((double) overTime / unitTime); // 올림 계산
            int price = units * unitFare;
            cars.put(carNum, basicFare + price);
        }
    }

    public int getTimeOfUse(String in, String out) {
        String[] inStr = in.split(":");
        String[] outStr = out.split(":");
        int inHour = Integer.parseInt(inStr[0]);
        int inMin = Integer.parseInt(inStr[1]);
        int outHour = Integer.parseInt(outStr[0]);
        int outMin = Integer.parseInt(outStr[1]);

        if (inHour == outHour) {
            return outMin - inMin;
        }

        // 1시간 이상 이용한 경우
        if (outMin >= inMin) {
            return (outHour - inHour) * 60 + (outMin - inMin);
        } else {
            return (outHour - inHour - 1) * 60 + (60 + outMin - inMin);
        }
    }
}