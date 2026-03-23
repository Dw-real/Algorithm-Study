class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rux = -1;
        int ruy = -1;

        for (int i=0; i<wallpaper.length; i++) {
            for (int j=0; j<wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rux = Math.max(rux, i + 1);
                    ruy = Math.max(ruy, j + 1);
                }
            }
        }

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rux;
        answer[3] = ruy;

        return answer;
    }
}