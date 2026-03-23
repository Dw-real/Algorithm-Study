class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int cast = bandage[0]; // 시전 시간
        int recovery = bandage[1]; // 초당 회복량
        int addRecovery = bandage[2]; // 추가 회복량
        int preAttackTime = attacks[0][0];
        int nowHealth = health; // 현재 체력

        for (int i=0; i<attacks.length; i++) {
            int time = attacks[i][0];
            int damage = attacks[i][1];
            int term = time - preAttackTime - 1;

            if (term > 0) {
                nowHealth += (term * recovery);
                nowHealth += ((term / cast) * addRecovery);

                if (nowHealth > health)
                    nowHealth = health;
            }

            nowHealth -= damage;
            if (nowHealth <= 0)
                return -1;
            
            preAttackTime = time;
        }
        return nowHealth;
    }
}