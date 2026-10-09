class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(answer, compact(s, i));
        }

        return answer;
    }

    public int compact(String s, int unit) {
        StringBuilder sb = new StringBuilder();

        String start = s.substring(0, unit);

        int count = 1;
        for (int i = unit; i < s.length(); i += unit) {
            String str = s.substring(i, Math.min(s.length(), i + unit));
            if (str.equals(start)) {
                count++;
            } else {
                if (count >= 2) {
                    sb.append(count);
                }
                sb.append(start);
                start = str;
                count = 1;
            }
        }
        if (count >= 2) {
            sb.append(count);
        }
        sb.append(start);
        return sb.length();
    }
}