class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int schedule = schedules[i];
            boolean gift = true; // 상품 수령 가능 여부

            for (int j = 0; j < timelogs[i].length; j++) {
                int day = j + startday;
                if (day % 7 == 0 || day % 7 == 6) { // 주말 출근은 이벤트에 적용되지 않음
                    continue;
                }
                if (isLate(schedule, timelogs[i][j])) {
                    gift = false;
                    break;
                }
            }

            if (gift) answer++; // 평일동안 지각하지 않은 경우 상품을 받는다
        }

        return answer;
    }

    public boolean isLate(int schedule, int timelog) {
        return toMinute(timelog) - toMinute(schedule) > 10;
    }

    public int toMinute(int time) {
        int hour = time / 100;
        int minute = time % 100;

        return hour * 60 + minute;
    }
}