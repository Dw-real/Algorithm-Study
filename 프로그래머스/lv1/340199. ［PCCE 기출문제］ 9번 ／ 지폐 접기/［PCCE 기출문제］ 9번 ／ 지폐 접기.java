class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (true) {
            if (isValid(wallet, bill[0], bill[1]))
                break;
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            }
            else if (bill[0] < bill[1]) {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }

    public boolean isValid(int[] wallet, int x, int y) {
        if ((wallet[0] >= x && wallet[1] >= y) || (wallet[0] >= y && wallet[1] >= x))
            return true;
        else
            return false;
    }
}