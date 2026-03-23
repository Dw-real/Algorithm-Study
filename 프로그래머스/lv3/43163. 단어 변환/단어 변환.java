class Solution {
    static boolean[] visited;
    static int answer;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = 0;
        dfs(begin, target, words, 0);
        return answer;
    }

    public void dfs(String word, String target, String[] words, int count) {
        if (word.equals(target)) {
            answer = count;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (visited[i])
                continue;

            int eq = 0; // 알파벳이 같은 부분

            for (int j = 0; j < target.length(); j++) {
                if (word.charAt(j) == words[i].charAt(j)) {
                    eq++;
                }
            }
            if (eq == target.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }
}