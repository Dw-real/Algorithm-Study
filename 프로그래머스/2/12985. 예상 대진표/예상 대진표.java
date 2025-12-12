class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        for (int i = 1; i <= n / 2; i++) {
            if ((a + 1) / 2 == (b + 1) / 2) {
                answer = i;
                break;
            }
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return answer;
    }
}