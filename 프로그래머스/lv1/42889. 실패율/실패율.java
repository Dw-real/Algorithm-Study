import java.util.*;

class Stage implements Comparable<Stage> {
    int step;
    double failure;

    public Stage(int step, double failure) {
        this.step = step;
        this.failure = failure;
    }

    @Override
    public int compareTo(Stage s) {
        if (this.failure == s.failure)
            return this.step - s.step;
        else
            return Double.compare(s.failure, this.failure);
    }
}

class Solution {
    static PriorityQueue<Stage> failure;

    public int[] solution(int N, int[] stages) {
        failure = new PriorityQueue<>();
        int[] answer = new int[N];
        for (int i=1; i<=N; i++) {
            int arrive = 0; // 해당 스테이지에 도달한 수
            int fail = 0; // 해당 스테이지를 클리어하지 못함
            for (int j=0; j<stages.length; j++) {
                if (stages[j] >= i) {
                    arrive++;
                    if (stages[j] == i)
                        fail++;
                }
            }
            if (arrive == 0) { // 도달한 사람이 없는 경우 실패율은 0
                failure.add(new Stage(i, 0.0));
                continue;
            }
            failure.add(new Stage(i, (double)fail/arrive));
        }
        int index = 0;
        while (!failure.isEmpty()) {
            Stage s = failure.poll();
            answer[index++] = s.step;
        }
        return answer;
    }
}