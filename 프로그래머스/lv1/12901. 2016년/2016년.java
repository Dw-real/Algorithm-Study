class Solution {
    static String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    static int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String solution(int a, int b) {
        int idx = 5;
        int d = 0;
        for (int i=0; i<a - 1; i++) {
            d += month[i];
        }
        d += b - 1;
        return day[(idx + d) % 7];
    }
}