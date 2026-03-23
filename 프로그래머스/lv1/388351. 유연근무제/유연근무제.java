class Solution {
    public  int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i=0; i<timelogs.length; i++) {
            int cutLine = getCutLine(schedules[i]);
            boolean flag = true; // 상품 수여 가능 여부
            int day = startday;
            for (int j=0; j< timelogs[i].length; j++) {

                if (day < 6) {
                    if (timelogs[i][j] > cutLine) {
                        flag = false;
                        break;
                    }
                }

                day++;
                if (day == 8)
                    day = 1;
            }
            if (flag)
                answer++;
        }

        return answer;
    }

    // 출근 인정 시각
    public int getCutLine(int schedule) {
        int hour = schedule / 100; // 시간
        int minute = schedule % 100; // 분

        if (minute + 10 >= 60) {
            hour += 1;
            minute -= 50;
        } else {
            minute += 10;
        }

        return hour * 100 + minute;
    }
}