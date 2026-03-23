import java.util.*;

class Time implements Comparable<Time> {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time t) {
        return this.end - t.end;
    }
}

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, Comparator.comparingInt(o -> toMinute(o[0])));

        PriorityQueue<Time> pq = new PriorityQueue<>();

        for (String[] time : book_time) {
            int start = toMinute(time[0]);
            int end = toMinute(time[1]);

            if (pq.isEmpty()) { // 사용 중인 방이 없는 경우
                pq.add(new Time(start, end));
            } else {
                if (pq.peek().end + 10 > start) { // 가장 빨리 끝나는 대실 종료 시각(청소 시간 10분 포함)보다 대실 시작 시각이 이른 경우 
                    pq.add(new Time(start, end));
                } else {
                    pq.poll();
                    pq.add(new Time(start, end));
                }
            }
        }

        return pq.size();
    }

    public int toMinute(String s) {
        String[] time = s.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        return hour * 60 + minute;
    }
}