class Solution {
    public String solution(int[] food) {
        String answer = "";
        for (int i=1; i<food.length; i++) { // food[0]은 항상 물
            int count = food[i] / 2;
            for (int j=0; j<count; j++) {
                answer += i;
            }
        }

        String str = "";

        for (int i=answer.length() - 1; i>=0; i--) {
            str += answer.charAt(i);
        }

        return answer + '0' + str;
    }
}