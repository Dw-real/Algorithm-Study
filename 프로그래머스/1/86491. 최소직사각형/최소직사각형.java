class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];
            if (height > width) {
                int tmp = width;
                width = height;
                height = tmp;
            }
            w = Math.max(w, width);
            h = Math.max(h, height);
        }
        return w * h;
    }
}