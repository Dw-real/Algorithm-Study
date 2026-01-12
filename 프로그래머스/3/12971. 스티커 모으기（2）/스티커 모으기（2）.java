class Solution {
    static int solution(int sticker[]) {
        int length = sticker.length;
        
        if (length == 1) {
            return sticker[0];
        }
        
        int[] dp1 = new int[length + 1]; // 첫 번째 스티커를 선택한 경우
        int[] dp2 = new int[length + 1]; // 첫 번째 스티커를 선택하지 않은 경우
        dp1[1] = sticker[0];

        for (int i = 2; i <= length; i++) {
            dp1[i] = Math.max(dp1[i - 2] + sticker[i - 1], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + sticker[i - 1], dp2[i - 1]);
        }

        return Math.max(dp1[length - 1], dp2[length]);
    }
}