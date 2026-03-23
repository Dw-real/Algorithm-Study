class Solution {
    static int[] answer = {0, 0};
    
    public int[] solution(String s) {
        while (!s.equals("1")) {
            s = deleteZero(s);
            answer[0]++;
        }
        return answer;
    }

    public String deleteZero(String s) {
        int len = s.length();
        s = s.replace("0", "");
        answer[1] += (len - s.length());
        return Integer.toBinaryString(s.length());
    }
}