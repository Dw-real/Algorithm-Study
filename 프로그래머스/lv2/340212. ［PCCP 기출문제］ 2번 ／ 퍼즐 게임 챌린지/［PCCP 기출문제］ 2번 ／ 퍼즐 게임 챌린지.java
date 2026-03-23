class Solution {
    public boolean isPossible(int[] diffs, int[] times, long limit, int mid) {
        long time = times[0];

        for (int i=1; i<diffs.length; i++) {
            if (diffs[i] <= mid) {
                time += times[i];
            }
            else {
                int time_cur = times[i];
                int time_prev = times[i - 1];

                time += (time_cur + time_prev) * (diffs[i] - mid) + times[i];
            }
        }

        if (time <= limit)
            return true;
        else
            return false;
    }

    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int low = 1;
        int high = 3000000;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (isPossible(diffs, times, limit, mid)) {
                answer = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return answer;
    }

}