class Solution {
    int solution(int[][] land) {
        int answer = 0;
        for (int i=1; i<land.length; i++) {
            land[i][0] += getMax(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
            land[i][1] += getMax(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
            land[i][2] += getMax(land[i - 1][0], land[i - 1][1], land[i - 1][3]);
            land[i][3] += getMax(land[i - 1][0], land[i - 1][1], land[i - 1][2]);
        }
        for (int i=0; i<4; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }
        return answer;
    }
    
    public int getMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}