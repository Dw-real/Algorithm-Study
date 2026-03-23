class Solution {
    public String solution(String new_id) {
        String answer = new_id
                .toLowerCase()// 1단계
                .replaceAll("[^a-z0-9-_.]", "") // 2단계
                .replaceAll("[.]{2,}", ".") // 3단계
                .replaceAll("^[.]|[.]$", ""); // 4단계

        if (answer.isEmpty()) answer += 'a'; // 5단계
        if (answer.length() >= 16) { // 6단계
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        if (answer.length() <= 2) { // 7단계
            while (answer.length() != 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }
        return answer;
    }
}