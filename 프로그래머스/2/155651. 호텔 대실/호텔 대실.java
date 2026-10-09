import java.util.*;

class Booking implements Comparable<Booking> {
    int start;
    int end;

    public Booking(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Booking b) {
        return this.end - b.end;
    }
}

class Solution {
    public int solution(String[][] book_time) {
        // 예약 시작 시간 기준 오름차순 정렬
        Arrays.sort(book_time, Comparator.comparingInt(o -> toMinute(o[0])));
        PriorityQueue<Booking> pq = new PriorityQueue<>();

        for (String[] time : book_time) {
            int start = toMinute(time[0]);
            int end = toMinute(time[1]);

            if (pq.isEmpty()) { // 사용 중인 방이 없는 경우
                pq.add(new Booking(start, end));
            } else {
                if (pq.peek().end + 10 > start) {
                    pq.add(new Booking(start, end));
                } else {
                    pq.poll();
                    pq.add(new Booking(start, end));
                }
            }
        }

        return pq.size();
    }

    public int toMinute(String time) {
        String[] str = time.split(":");
        int hour = Integer.parseInt(str[0]);
        int minute = Integer.parseInt(str[1]);

        return hour * 60 + minute;
    }
}