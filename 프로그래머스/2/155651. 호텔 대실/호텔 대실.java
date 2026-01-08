class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] time = new int[1450]; // 청소시간 10분 고려

        for (String[] bookTime : book_time) {
            int start = toMinute(bookTime[0]);
            int end = toMinute(bookTime[1]);
            for (int i = start; i < end + 10; i++) { // 청소 시간 고려
                time[i]++;
            }
        }

        for (int i = 0; i < 1450; i++) {
            answer = Math.max(answer, time[i]);
        }

        return answer;
    }

    public int toMinute(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);

        return hour * 60 + minute;
    }
}