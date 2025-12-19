import java.util.*;

class Solution {
    static char[] moeum = {'A', 'E', 'I', 'O', 'U'};
    static ArrayList<String> words;

    public int solution(String word) {
        words = new ArrayList<>();

        for (int i = 1; i <= moeum.length; i++) {
            dfs(new StringBuilder(), 0, i);
        }

        Collections.sort(words);
        return words.indexOf(word) + 1;
    }


    public void dfs(StringBuilder sb, int len, int depth) {
        if (len == depth) {
            words.add(sb.toString());
            return;
        }
        for (int i = 0; i < moeum.length; i++) {
            sb.append(moeum[i]);
            dfs(sb, len + 1, depth);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}