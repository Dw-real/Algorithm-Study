class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey != 0) {
            int n = storey % 10; // 가장 낮은 자릿수
            storey /= 10; // 자릿수 이동

            if (n < 5) { // 자릿수가 5보다 작은 경우 내려가는게 빠름
                answer += n;
            } else if (n > 5) { // 자릿수가 5보다 큰 경우 올라가는게 빠름
                answer += (10 - n);
                storey++;
            } else { // 자릿수가 5인 경우 다음 자릿수를 통해 판단
                answer += 5;
                if (storey % 10 >= 5) storey++;
            }
        }

        return answer;
    }
}