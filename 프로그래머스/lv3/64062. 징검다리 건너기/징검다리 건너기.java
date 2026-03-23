class Solution {
    static int answer = 0;
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 0;
        for (int count : stones) {
            right = Math.max(right, count);
        }

        binarySearch(stones, left, right, k);
        return answer + 1;
    }

    public void binarySearch(int[] stones, int left, int right, int k) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;

            if (isValid(stones, mid, k)) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
    }

    public boolean isValid(int[] stones, int mid, int k) {
        int count = 0;

        for (int cnt : stones) {
            if (cnt - mid <= 0)
                count++;
            else
                count = 0;
            if (count >= k)
                return false;
        }
        return true;
    }
}