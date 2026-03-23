class Solution {
    private long answer;

    public long solution(int n, int[] times) {
        long maxTime = (long)1000000000 * (long)1000000000;
        long minTime = 1;
        answer = maxTime;
        searchTime(times, n, minTime, maxTime);
        return answer;
    }

    public void searchTime(int[] times, int n, long minTime, long maxTime) {
        while (minTime <= maxTime) {
            long mid = (minTime + maxTime) / 2;

            long timeCnt = 0;
            for (int time : times) {
                timeCnt += (mid / time);
            }

            if (timeCnt >= n) {
                answer = Math.min(answer, mid);
                maxTime = mid - 1;
            }
            else {
                minTime = mid + 1;
            }
        }
    }
}