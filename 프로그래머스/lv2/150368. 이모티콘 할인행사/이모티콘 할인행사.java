class Solution {
    static int[] answer = new int[2];
    static int[] rate = {10, 20, 30, 40};
    static int subscribers; // 최대 가입자
    static int totalAmount; // 최대 금액

    public int[] solution(int[][] users, int[] emoticons) {
        int m = emoticons.length;

        subscribers = 0;
        totalAmount = 0;
        int[] discount = new int[m]; // 각 이모티콘의 할인률

        permutation(discount, users, emoticons, 0);

        answer[0] = subscribers;
        answer[1] = totalAmount;

        return answer;
    }

    public void permutation(int[] discount, int[][] users, int[] emoticons, int depth) {
        if (depth == discount.length) {
            checkCondition(discount, users, emoticons);
            return;
        }
        for (int i = 0; i < 4; i++) {
            discount[depth] = rate[i];
            permutation(discount, users, emoticons, depth + 1);
        }
    }

    public void checkCondition(int[] discount, int[][] users, int[] emoticons) {
        int plus = 0;
        int total = 0;

        for (int[] user : users) {
            int r = user[0]; // 기준 할인율
            int ref = user[1]; // 이모티콘 플러스를 가입할 기준 금액
            int amount = 0; // 이모티콘 구매 금액

            for (int i = 0; i < discount.length; i++) {
                if (discount[i] >= r) {
                    amount += emoticons[i] * (100 - discount[i]) / 100;
                }
            }
            if (amount >= ref) {
                plus++;
            } else {
                total += amount;
            }
        }
        if (plus > subscribers) { // 이모티콘 플러스 가입자 수가 갱신된 경우
            subscribers = plus;
            totalAmount = total;
        } else if (plus == subscribers){
            totalAmount = Math.max(totalAmount, total);
        }
    }
}