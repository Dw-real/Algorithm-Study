import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> users = new HashMap<>(); // (유저 아이디, 닉네임)
        ArrayList<String> answer = new ArrayList<>();

        for (String r : record) {
            String[] str = r.split(" ");
            String firstWord = str[0];
            String uid = str[1];

            // 첫 단어가 Enter, Change인 경우 uid에 대한 닉네임 저장
            if (firstWord.equals("Enter") || firstWord.equals("Change")) {
                String nickname = str[2];
                users.put(uid, nickname);
            }
        }

        for (String r : record) {
            String[] str = r.split(" ");
            String firstWord = str[0];
            String uid = str[1];

            if (firstWord.equals("Enter")) {
                answer.add(users.get(uid) + "님이 들어왔습니다.");
            } else if (firstWord.equals("Leave")) {
                answer.add(users.get(uid) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[]{});
    }
}