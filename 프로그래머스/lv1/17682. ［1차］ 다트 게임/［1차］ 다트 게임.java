class Solution {
    public int solution(String dartResult) {
        int[] point = new int[3];
        int index = 0;
        String tmp = "";
        for (int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (c >= '0' && c <= '9')
                tmp += c;
            else if (c == 'S' || c == 'D' || c == 'T') {
                int score = Integer.parseInt(tmp);
                if (c == 'S')
                    point[index++] = (int)Math.pow(score, 1);
                else if (c == 'D')
                    point[index++] = (int)Math.pow(score, 2);
                else if (c == 'T')
                    point[index++] = (int)Math.pow(score, 3);
                tmp = "";
            }
            else {
                if (c == '#') {
                    point[index - 1] *= -1;
                }
                else {
                    point[index - 1] *= 2;
                    if (index - 2 >= 0)
                        point[index - 2] *= 2;
                }
            }
        }

        int answer = 0;
        for (int value : point) {
            answer += value;
        }
        return answer;
    }
}