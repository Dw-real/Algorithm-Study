class Solution {
    public int solution(int n) {
        int answer = n + 1;

        while (oneCount(answer) != oneCount(n)) {
            answer++;
        }

        return answer;
    }

    public int oneCount(int n) {
        int count = 0;
        while (n >= 2) {
            if (n % 2 == 1)
                count++;
            n /= 2;
        }
        return count;
    }
}