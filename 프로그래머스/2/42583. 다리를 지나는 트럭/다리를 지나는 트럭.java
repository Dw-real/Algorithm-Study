import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> q = new LinkedList<>();

        int w = 0; // 현재 다리에 있는 트럭의 무게
        for (int truckWeight : truck_weights) {
            while (true) {
                if (q.isEmpty()) { // 다리에 트럭이 없는 경우
                    w += truckWeight;
                    q.add(truckWeight);
                    time++;
                    break;
                } else if (q.size() == bridge_length) {
                    w -= q.poll();
                } else {
                    if (w + truckWeight <= weight) {
                        w += truckWeight;
                        q.add(truckWeight);
                        time++;
                        break;
                    } else {
                        q.add(0);
                        time++;
                    }
                }

            }
        }

        return time + bridge_length;
    }
}