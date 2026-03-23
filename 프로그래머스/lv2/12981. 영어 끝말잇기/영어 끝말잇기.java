import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        char prev = words[0].charAt(words[0].length() - 1);

        for (int i = 1; i < words.length; i++) {
            int num = (i % n) + 1; // 참가자 번호
            int order = (i / n) + 1;; // 해당 참가자의 차례 수
            String word = words[i];

            if (!validWord(prev, word, set)) {
                answer[0] = num;
                answer[1] = order;
                break;
            } else {
                set.add(word);
                prev = word.charAt(word.length() - 1);
            }
        }


        return answer;
    }

    public boolean validWord(char prev, String word, HashSet<String> set) {
        return (!set.contains(word) && prev == word.charAt(0));
    }
}