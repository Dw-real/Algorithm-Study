import java.util.*;

class Solution {
    static char[] moeum = {'A', 'E', 'I', 'O', 'U'};
    static ArrayList<String> words = new ArrayList<>();

    static int solution(String word) {
        words.clear();
        dfs(new StringBuilder());

        Collections.sort(words);
        return words.indexOf(word);
    }

    static void dfs(StringBuilder sb) {
        words.add(sb.toString());

        if (sb.length() == 5)
            return;

        for (char c : moeum) {
            sb.append(c);
            dfs(sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}