class Solution {
    public String solution(String phone_number) {
        String answer = setCode(phone_number);
        return answer;
    }
    
    public String setCode(String phone_number) {
        int length = phone_number.length();
        StringBuilder sb = new StringBuilder(phone_number);
        for (int i=0; i<length - 4; i++) {
            sb.setCharAt(i, '*');
        }
        return sb.toString();
    }
}