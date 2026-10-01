class Solution {
    static boolean[] visited;
    static int answer;

    static int solution(String begin, String target, String[] words) {
        int len = words.length;
        visited = new boolean[len];
        answer = 0;

        transformWord(begin, target, words, 0);

        return answer;
    }

    static void transformWord(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = count;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (visited[i])
                continue;

            int eq = 0; // 같은 알파벳 개수

            for (int j=0; j<begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    eq++;
                }
            }

            if (eq == begin.length() - 1) {
                visited[i] = true;
                transformWord(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }

}