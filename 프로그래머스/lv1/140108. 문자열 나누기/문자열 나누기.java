class Solution {
    public int solution(String s) {
        int answer = 0;
        int countX = 0; // 첫글자의 수
        int count = 0; // 첫글자가 아닌 글자의 수
        char x = ' ';

        for (int i=0; i<s.length(); i++) {
            if (countX == 0) {
                x = s.charAt(i);
                countX++;
            } else {
                if (s.charAt(i) == x) {
                    countX++;
                } else {
                    count++;
                }
            }

            if (countX == count) {
                answer++;
                countX = 0;
                count = 0;
            }
        }
        if (countX != 0 || count != 0) {
            answer++;
        }
        
        return answer;
    }
}